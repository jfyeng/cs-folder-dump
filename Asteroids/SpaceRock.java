
// SpaceRock.java
// James Feng
// Organize spacerock fields and methods

import static java.lang.Math.*;

import java.awt.*;
import java.awt.geom.Area;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

class SpaceRock extends Entity {

    private double rotation;
    private final double radius, rotation_speed;
    private ArrayList<Double> poly_angles = new ArrayList<Double>();
    private boolean dead = false;

    // constructor
    public SpaceRock(AstGame g, double x, double y, double r) {
        Random rand = new Random();
        radius = r;
        rotation_speed = (rand.nextDouble(2*PI) - PI)/(radius/10);
        game = g;

        double speed = (2000/radius) * (rand.nextDouble(1)+.3);
        double angle = rand.nextDouble(2*PI);

        this.x = x + 0.5*radius*cos(angle);
        this.y = y + 0.5*radius*cos(angle);

        vx = speed*cos(angle);
        vy = speed*sin(angle);

        // if the rock is too small, just make it disappear instead
        if (radius < 10) { this.dead = true; return; }

        // generate random angles for the polygon shape
        poly_angles.add(rand.nextDouble(2*PI));
        poly_angles.add(rand.nextDouble(2*PI));
        poly_angles.add(rand.nextDouble(2*PI));
        boolean flag;
        // a do while loop is used to make sure the polygon doesn't have an angle too big in it
        do {
            flag = false;
            Collections.sort(poly_angles);
            ArrayList<Double> angcopy = new ArrayList<Double>(poly_angles);
            angcopy.add(angcopy.get(0) + 2*PI);
            for (int i = 0; i+1 < angcopy.size(); ++i) {
                if (angcopy.get(i+1) - angcopy.get(i) >= 0.5*PI) {
                    poly_angles.add(rand.nextDouble(angcopy.get(i+1) - angcopy.get(i)) + angcopy.get(i));
                    flag = true;
                }
            }
        } while (flag);
    }

    // update properties 
    public boolean update(double dt) {
        if (dead) return true;

        x += vx*dt - game.getPlayer().getVel()[0]*dt;
        y += vy*dt - game.getPlayer().getVel()[1]*dt;

        rotation += rotation_speed*dt;

        wrap();

        // collisions with bullets
        Area shape = new Area(getPoly());
        for (Bullet b : game.getBullets()) {
            if (shape.contains(b.getPos()[0], b.getPos()[1])) {
                game.increaseScore((int)(max(0, game.getScoreOffset() - radius)));
                game.playExplosion();
                this.kill();
                b.kill();
                return true;
            }
        }

        // collision with player
        if (game.getMode() == 0) {
            shape = new Area(getPoly());
            shape.intersect(new Area(game.getPlayer().getPoly()));
            if (!shape.isEmpty()) {
                game.getPlayer().damage((int)(radius)); game.playExplosion(); kill();
            }
        }

        // collision with enemy
        for (Enemy e : game.getEnemies()) {
            shape = new Area(getPoly());
            shape.intersect(new Area(e.getPoly()));
            if (!shape.isEmpty()) {
                e.damage((int)(radius)); game.playExplosion(); kill();
            }
        }

        return false;
    }

    @Override
    public void kill() {
        this.dead = true;
        game.getSpaceRocks().add(new SpaceRock(game, x, y, radius/2));
        game.getSpaceRocks().add(new SpaceRock(game, x, y, radius/2));
    }

    // draw the polygon on the screen
    public void render(Graphics g) {
        if (dead) return;

        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3));
        
        g.setColor(Color.WHITE);
        g2.drawPolygon(getPoly());
    }

    public Polygon getPoly() {
        Polygon shape = new Polygon();
        for (int i = 0; i < poly_angles.size(); ++i) {
            shape.addPoint((int)(x + radius*cos(poly_angles.get(i) + rotation)), (int)(y + radius*sin(poly_angles.get(i) + rotation)));
        }
        return shape;
    }

    public double[] getPos() { return new double[]{x, y}; }
    public double getRadius() { return radius; }
}