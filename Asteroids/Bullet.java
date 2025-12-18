
// Bullet.java
// James Feng
// Organizes all the enemy's properties and methods

import java.awt.*;

import static java.lang.Math.*;

class Bullet extends Entity {

    private final int radius = 2;
    private final double speed = 1000;
    private double age = 0;
    private Color color;

    // constructor
    public Bullet(AstGame g, double angle, double x, double y, double vix, double viy, Color c) {
        this.game = g;
        this.x = x + game.getPlayer().getRadius()*cos(angle);
        this.y = y + game.getPlayer().getRadius()*sin(angle);
        vx = speed*cos(angle) + vix;
        vy = speed*sin(angle) + viy;
        this.color = c;
    }

    // update properties
    public boolean update(double dt) {
        if (dead) return true;

        if (color.equals(Color.RED)) {
            dt/=1.5;
        }

        x += vx*dt - game.getPlayer().getVel()[0]*dt;
        y += vy*dt - game.getPlayer().getVel()[1]*dt;

        // wrap around the screen
        wrap();

        // collision with enemy if this is a player bullet
        if (color.equals(Color.WHITE)) {
            for (Enemy e : game.getEnemies()) {
                if (e.getPoly().contains(x, y)) {
                    e.damage(9999999); this.kill();
                }
            }
        }

        // collision with player if this is an enemy bullet
        if (color.equals(Color.RED)) {
            if (game.getPlayer().getPoly().contains(x, y)) {
                game.getPlayer().damage(50); this.kill();
            }
        }

        age += dt;
        if (age > 1) { this.dead = true; return true; }
        return false;
    }

    // draw the square on the screen
    public void render(Graphics g) {
        if (dead) return;

        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(1));

        g.setColor(color);
        g.fillRect((int)(x - radius), (int)(y - radius), (int)(radius*2), (int)(radius*2));
    }

    // get bullet color
    public Color getColor() { return color; }
}