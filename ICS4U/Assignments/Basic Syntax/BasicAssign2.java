// BasicAssign2.java
// James
// takes in a String of 'B's and 'W's, and compresses it using RLE encoding, into a String that has numbers, 'B's, and 'W's

import java.util.Scanner;

class BasicAssign2 {
    public static void main(String[] owo) {
        Scanner kb = new Scanner(System.in);

        // INPUT
        System.out.print("Enter some 'B's and 'W's! >> ");
        String line = kb.nextLine();
        // placeholder special character to signal end
        // this is needed because without it, my iterator will stop before the encoding can finalize
        line += "~";
        
        char cur = '~';
        int count = 0;
        String result = "";
        for (int i = 0; i < line.length(); ++i) {
            // we've just began... set the counter and cur values
            if (cur == '~') {
                cur = line.charAt(i);
                count = 1; continue;
            }
            // still on the current character
            if (cur == line.charAt(i)) {
                ++count; continue;
            }
            // the character has changed. finalize the segment and then swap current char.
            result += "" + count + cur;
            cur = line.charAt(i);
            count = 1;
        }

        // OUTPUT
        System.out.println("RLE: " + result);
    }
}