
// Entity.java
// James Feng
// an abstract class with base fields and methods that all entities may need for easy access without defining it every time

import static java.lang.Math.*;

public abstract class Entity {
    protected double x = 0, y = 0, vx = 0, vy = 0;
    protected boolean dead = false;
    protected AstGame game;

    // get distance between this entity and another
    public double dist(Entity o) {
         return sqrt(pow(x - o.getPos()[0], 2) + pow(y - o.getPos()[1], 2)); 
    }

    // get angle between this entity and another
    public double angle(Entity o) {
        return atan2(o.getPos()[1] - y, o.getPos()[0] - x);
    }

    // wrap the entity around the screen based on a value set by AstGame
    public void wrap() {
        if (x < -game.getBoundMargin()) x = game.WH()[0] + game.getBoundMargin();
        if (x > game.WH()[0] + game.getBoundMargin()) x = -game.getBoundMargin();
        if (y < -game.getBoundMargin()) y = game.WH()[1] + game.getBoundMargin();
        if (y > game.WH()[1] + game.getBoundMargin()) y = -game.getBoundMargin();
    }

    // check if this entity's center is on the screen
    public boolean visible() {
        return 0 <= x && x <= game.WH()[0] && 0 <= y && y <= game.WH()[1];
    }

    public void revive() { this.dead = false; }
    public void kill() { this.dead = true; }

    public double[] getPos() { return new double[]{x, y}; }
    public double[] getVel() { return new double[]{vx, vy}; }

}
