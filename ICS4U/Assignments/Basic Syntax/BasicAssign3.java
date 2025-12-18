// BasicAssign3.java
// James
// Program that allows user to enter coordinates for a point, and a line, and tells the user if the point is on the line or not.

import java.util.Scanner;
import java.awt.geom.Line2D;

class BasicAssign3 {
    public static void main(String[] owo) {
        Scanner kb = new Scanner(System.in);

        // INPUT
        System.out.print("Enter coordinates for a point and a line in the form: px py x1 y1 x2 y2 >> ");
        // I don't know how to do this more efficiently yet
        double px = kb.nextDouble(), py = kb.nextDouble();
        double  x1 = kb.nextDouble(), y1 = kb.nextDouble(), x2 = kb.nextDouble(), y2 = kb.nextDouble();

        // It took me ages to figure out a way to use Line2D.
        // UPDATE: maybe I used Line2D wrong, but I'm pretty sure the formula is literally more accurate...
        // try something like the following input:
        // 2 2.000000001 1 1 3 3

        Line2D line = new Line2D.Double(x1, y1, x2, y2);
        if (Math.abs(line.ptLineDist(px, py)) < 0.00001) { // I think this is the default epsilon.
            System.out.println("The point is on the line!");
        } else {
            System.out.println("The point is not on the line!");
        }

        // double dist = Math.hypot(x1-x2, y1-y2);
        // if (Math.hypot(x1-x2, y1-y2) == Math.hypot(x1-px, y1-py) + Math.hypot(x2-px,y2-py)) {
        //     System.out.println("The point is on the line!");
        // } else {
        //     System.out.println("The point is not on the line!");
        // }
    }
}