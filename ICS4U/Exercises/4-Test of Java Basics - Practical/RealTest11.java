// RealTest11.java
// James
// Generates sidelengths for right angle triangles.

import java.util.Scanner;
import java.util.Random;

class RealTest11 {
    public static void main(String[] owo) {
        Scanner kb = new Scanner(System.in);
        Random rand = new Random();

        int MAX_SIDELEN = 50;

        System.out.print("How many triangles? >> ");
        int triangle_count = kb.nextInt();

        for (int i = 0; i < triangle_count; ++i) {
            boolean flag = false;
            for (int hyp = rand.nextInt(MAX_SIDELEN)+1; !flag; hyp = hyp%MAX_SIDELEN+1) {
                for (int a = rand.nextInt(MAX_SIDELEN)+1, c = 0; !flag && c < MAX_SIDELEN; a = a%MAX_SIDELEN+1, ++c) {
                    double b = Math.sqrt(Math.pow(hyp, 2) - Math.pow(a, 2));
                    if (b % 1 == 0 && b > 0) {
                        System.out.printf("%d %d %d\n", a, (int)b, hyp);
                        flag = true;
                    }
                }
            }
        }
    }
}