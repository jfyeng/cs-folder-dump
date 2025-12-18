
// Player.java
// James Feng
// Organizes all the player's properties and methods

import java.awt.*;
import java.awt.event.*;

import static java.lang.Math.*;

class Player extends Entity {

    private final double 
        acceleration = 1000, // pixels per second^2
        turn_speed = .7*2*PI, // radians per second
        radius = 28,
        ship_angle = 0.4*2*PI, // constant used to draw the ship
        regeneration_speed = (double)2/1 // regeneration speed in health per second
    ;

    private double
        fire_rate = (double)1/5, // fire rate in seconds per shot
        rotation = -0.5*PI, 
        last_fire = 0,
        health = 100
    ;

    private boolean accelerating = false, flicker = false;

    public Player(AstGame a) { // constructor
        game = a;
        x = game.WH()[0]/2;
        y = game.WH()[1]/2;
    }

    // update position and properties every frame based on change in time (dt)
    public boolean update(double dt) {
        if (dead) return true;

        health = min(100, health + regeneration_speed*dt);

        // keys
        double ts = turn_speed * (game.getKeys()[KeyEvent.VK_SHIFT]? 0.5 : 1);
        if (game.getKeys()[KeyEvent.VK_LEFT]) rotation = (rotation - ts*dt) % (2*PI);
        if (game.getKeys()[KeyEvent.VK_RIGHT]) rotation = (rotation + ts*dt) % (2*PI);

        // AUTOMATIC FIRING
        if (game.getKeys()[KeyEvent.VK_SPACE]) {
            double fire_dt = (System.nanoTime() - last_fire) / 1e9;
            if (fire_dt >= fire_rate) {
                last_fire = System.nanoTime();
                game.getBullets().add(new Bullet(game, rotation, x, y, vx, vy, Color.WHITE));
                game.playShoot();
            }
        }

        // make the fire rate slowly increase up to a final speed
        fire_rate = (double)1/(min(game.getRockSpawnCount()/1.5, 30));

        // apply acceleration
        if (game.getKeys()[KeyEvent.VK_UP]) {
            accelerating = true;
            vx += acceleration*dt * cos(rotation);
            vy += acceleration*dt * sin(rotation);
        } else accelerating = false;

        // apply drag
        vx *= 1 - dt;
        vy *= 1 - dt;

        return false;
    }

    // decrement health
    public void damage(int dmg) {
        game.playHurt();
        health -= dmg;
        if (health <= 0) { this.dead = true; }
    }

    // get a polygon shape for rendering and for collisions
    public Polygon getPoly() {
        if (dead) return new Polygon();
        Polygon shape = new Polygon();
        shape.addPoint((int)(x + radius*cos(rotation)), (int)(y + radius*sin(rotation)));
        shape.addPoint((int)(x + radius*cos(rotation + ship_angle)), (int)(y + radius*sin(rotation + ship_angle)));
        shape.addPoint((int)(x + radius*cos(rotation - ship_angle)), (int)(y + radius*sin(rotation - ship_angle)));
        return shape;
    }

    // drawing the shapes for the ship
    public void render(Graphics g) {
        if (dead) return;

        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3));

        // draw health bar
        g.setColor(Color.GREEN);
        g.drawRect(game.WH()[0]/2 - 50, 25, 100, 10);
        g.fillRect(game.WH()[0]/2 - 50, 25, (int)health, 10);

        g.setColor(Color.WHITE);
        g2.drawPolygon(getPoly()); // draw ship body
        // flicker the fire every 25 ms, and drawing the booster
        flicker = System.currentTimeMillis() % 50 <= 25;
        if (accelerating && flicker) {
            Polygon booster = new Polygon();
            booster.addPoint((int)(x + radius*2*cos(rotation + PI)), (int)(y + radius*2*sin(rotation + PI)));
            booster.addPoint((int)(x + radius*cos(rotation + PI) + (radius/3)*cos(rotation + PI + 0.5*PI)), (int)(y + radius*sin(rotation + PI) + (radius/3)*sin(rotation + PI + 0.5*PI)));
            booster.addPoint((int)(x + radius*cos(rotation + PI) + (radius/3)*cos(rotation + PI - 0.5*PI)), (int)(y + radius*sin(rotation + PI) + (radius/3)*sin(rotation + PI - 0.5*PI)));
            g2.drawPolygon(booster);
        }
    }

    // reset velocity to zero
    public void resetMotion() { vx = 0; vy = 0; }
    // get player ship radius
    public double getRadius() { return radius; }

    // reset some variables when reviving
    @Override
    public void revive() {
        dead = false;
        rotation = -0.5*PI;
        last_fire = 0;
        vx = 0; vy = 0;
        health = 100;
    }
}