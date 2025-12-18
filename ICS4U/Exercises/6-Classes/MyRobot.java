
public class MyRobot {

    double x, y, heading;

    public MyRobot() {
        x = y = heading = 0;
    }

    public MyRobot(double x, double y, double angle) {
        this.x = x;
        this.y = y;
        this.heading = angle;
    }

    public void turn(double angle) {
        this.heading = ((this.heading + angle) % 360 + 360) % 360;
    }

    public void advance(double distance) {
        this.x += Math.cos(Math.toRadians(this.heading)) * distance;
        this.y += Math.sin(Math.toRadians(this.heading)) * distance;
    }

    @Override
    public String toString() {
        String ret = "X: %5.1f Y: %5.1f Heading: %5.1f";
        return String.format(ret, this.x, this.y, this.heading);
    }
}