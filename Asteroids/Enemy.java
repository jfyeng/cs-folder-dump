
// Enemy.java
// James Feng
// Organizes all the enemy's properties and methods

import java.awt.*;
import java.awt.geom.Area;
import java.util.Random;

import static java.lang.Math.*;

class Enemy extends Entity {

    private final double speed = 100, fire_rate = (double)2/1;
    private double radius = 35, angle, last_fire = System.nanoTime(), health = 100;

    public Enemy(AstGame a) { // constructor
        game = a;
        Point pos = game.randomOuterPos((int)radius);
        x = pos.x;
        y = pos.y;
        Random rand = new Random();
        angle = rand.nextDouble(2*PI);
        vx = speed*cos(angle);
        vy = speed*sin(angle);
    }

    // update properties
    public boolean update(double dt) {
        if (dead) return true;

        // move away from the closest spacerock if the closest spacerock is too close to us
        SpaceRock closest = null;
        for (SpaceRock sr : game.getSpaceRocks()) {
            if (closest == null) {
                closest = sr;
            }
            
            if (dist(sr) < dist(closest)) {
                closest = sr;
            }
        }
        if (closest != null) {
            if (dist(closest) <= (radius + closest.getRadius())*1.5) {
                angle = this.angle(closest) + PI;
            }
            vx = speed*cos(angle);
            vy = speed*sin(angle);
        }

        // apply velocity
        x += vx*dt - game.getPlayer().getVel()[0]*dt;
        y += vy*dt - game.getPlayer().getVel()[1]*dt;

        // fire if enough time has passed
        double fire_dt = (System.nanoTime() - last_fire) / 1e9;
        if (fire_dt >= fire_rate && visible()) {
            last_fire = System.nanoTime();
            double fire_error = PI/8;
            Random rand = new Random();
            // get angle and add a random fire error
            double aim_angle = this.angle(game.getPlayer()) + (rand.nextDouble(fire_error) - fire_error/2);
            game.getBullets().add(new Bullet(this.game, aim_angle, x, y, 0, 0, Color.RED));
        }

        wrap();

        // collision with player
        Area shape = new Area(getPoly());
        shape.intersect(new Area(game.getPlayer().getPoly()));
        if (!shape.isEmpty()) {
            game.getPlayer().damage(40); this.kill(); game.playExplosion();
        }

        return false;
    }

    // decrement health, kill if below 0
    public void damage(int dmg) {
        game.playExplosion();
        health -= dmg;
        if (health <= 0) {
            kill();
            game.playDing();
            game.increaseScore(1000);
        }
    }

    // get a polygon shape for rendering and for collisions
    public Polygon getPoly() {
        Polygon shape = new Polygon();
        shape.addPoint((int)(x - radius/3), (int)(y - radius/3));
        shape.addPoint((int)(x + radius/3), (int)(y - radius/3));
        shape.addPoint((int)(x - radius/3), (int)(y - radius/3));
        shape.addPoint((int)(x - radius/3), (int)(y - radius/1.5));
        shape.addPoint((int)(x + radius/3), (int)(y - radius/1.5));
        shape.addPoint((int)(x + radius/3), (int)(y - radius/3));
        shape.addPoint((int)(x + radius), (int)(y));
        shape.addPoint((int)(x + radius/3), (int)(y + radius/3));
        shape.addPoint((int)(x - radius/3), (int)(y + radius/3));
        shape.addPoint((int)(x - radius), (int)(y));
        return shape;
    }

    // draw on the screen
    public void render(Graphics g) {
        if (dead) return;

        g.setColor(Color.RED);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3));

        g2.drawPolygon(getPoly());
    }
}
