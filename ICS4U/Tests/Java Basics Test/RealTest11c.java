// RealTest11c.java
// James

import java.util.Random;
import java.util.Scanner;

class RealTest11c {
    public static void main(String[] owo) {
        Random rand = new Random();
        Scanner kb = new Scanner(System.in);

        System.out.println("How many can you do now?");
        int current = kb.nextInt();
        System.out.println("What is your goal?");
        int goal = kb.nextInt();

        for (int i = 1; current < goal; ++i) {
            current = Math.min(goal, current + (rand.nextInt(5)+1));
            System.out.printf("Day %d: %d\n", i, current);
        }
    }
}