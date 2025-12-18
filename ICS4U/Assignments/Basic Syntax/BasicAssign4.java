// BasicAssign4.java
// James
// this program will determine the average amount of birthdays that need to be randomly generated before we get a repeat.

import java.util.Scanner;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

class BasicAssign4 {
    public static void main(String[] owo) {
		int repeat_count = 10000;
        int graph_zoom = 18; // graph multiplier

        Random rand = new Random();
        double sum = 0; // used to get the average later, dividing by repeat_count

        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>(); // store frequencies of the gen counts

		Set<Integer> days = new HashSet<Integer>(); // keep track of which days we've generated already
        int hi = Integer.MIN_VALUE, lo = Integer.MAX_VALUE; // keeps track of high and low values
        for (int i = 0; i < repeat_count; ++i) {
			days.clear();
            int gen_count = 0; // the amount of birthdays generated
            while (true) {
				++gen_count;
                int birthday = rand.nextInt(365);
                // if it's a repeat, break, otherwise, add this day to set
				if (days.contains(birthday)) break;
				else days.add(birthday);
            }
			sum += gen_count;

            // increment frequency map values, update high and low values
            int mapval = freq.containsKey(gen_count) ? freq.get(gen_count) : 0;
            freq.put(gen_count, mapval+1);
            hi = Math.max(hi, gen_count); 
            lo = Math.min(lo, gen_count); 
        }

        // OUTPUT
		System.out.println("AVG: " + sum/repeat_count); // get and print avg

        // I have a huge urge to make a frequency graph...

        // Scanner kb = new Scanner(System.in);
        // System.out.print("SHOW GRAPH? Y/N >> ");
        // if (kb.nextLine().equalsIgnoreCase("Y")) {
        //     System.out.println("\nGEN | FREQ | PERCENTAGE");
        //     System.out.println("------------------------");
        //     for (int i = lo; i <= hi; ++i) {
        //         if (freq.containsKey(i)) {
        //             double percent = (double)freq.get(i) / repeat_count * 100 * graph_zoom; // percent + multiply more to scale the graph zoom
        //             String bar = "#".repeat((int)percent); // make a bar length based on the percent
        //             if ((int)percent == 0 && percent != 0) bar = "-"; // I want only 0 to show nothing, anything below 1 will show -
        //             System.out.printf("%3d | %4d | %s\n", i, freq.get(i), bar);
        //         } else {
        //             System.out.printf("%3d | %4d | %s\n", i, 0, ""); // empty case
        //         }
        //     }
        // }
    }
}
