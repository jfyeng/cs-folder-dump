import java.util.Random;
import java.awt.Point;

class ArrayEx3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int yard_size = 30;

        Point[] trees = new Point[10];
        while (true) {
            for (int i = 0; i++ != 10;) {
                trees[i-1] = new Point(rand.nextInt(yard_size)+1, rand.nextInt(yard_size)+1);
            }

            boolean flag = false;
            for (int i = 0; i++ != 10 && !flag;) {
                for (int j = i; j++ != 10 && !flag;) {
                    if (trees[i-1].distance(trees[j-1]) < 3) {
                        flag = true;
                    }
                }
            }
            if (flag) continue;
            break;
        }
        for (int i = 0; i++ != 10;) {
            System.out.println(trees[i-1].x + "," + trees[i-1].y);
        }
    }
}