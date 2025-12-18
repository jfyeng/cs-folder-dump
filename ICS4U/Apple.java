import java.awt.*;
import java.awt.geom.*;

class Apple {
    public static void main(String[] args) {
        Point p = new Point(5, 10);
        System.out.println(p);

        p.x = 2;
        p.translate(100, 50);
        System.out.println(p);
        System.out.println(p.distance(100,100));
        
        System.out.println(Point2D.distance(100, 100, 120, 90));
    }
}