// BasicAssign1.java
// James
// given a String input, this program will construct a cool hollow box using the characters from that String and output it

import java.util.Scanner;

class BasicAssign1 {
    public static void main(String[] owo) {
        Scanner kb = new Scanner(System.in);

        // INPUT
        System.out.print("Enter some text! >> ");
        String word = kb.nextLine();
        int len = word.length(); // length of String
        System.out.println("Behold!\n"); // :P

        if (len == 0) { // box * sidelen 0 should be no box...
            System.out.println("");
            return;
        }

        // TOP OF BOX
        System.out.println(word + word.charAt(0));

        // MIDDLE OF BOX
        // the hollow part of the box is constructed using len-1 spaces printed len-1 times
        // the letters on either side is placed according to the order of the original word using i, reversed on one side
        for (int i = 0; i < len-1; ++i) {
            System.out.println(word.charAt(len-1-i) + " ".repeat(len-1) + word.charAt(i+1));
        }

        // BOTTOM OF BOX
        // reversing the string
        String rev_word = "";
        for (int i = len-1; i >= 0; --i) {
            rev_word += word.charAt(i);
        }
        System.out.println(word.charAt(0) + rev_word);
    }
}

// the box doesn't even look like a square in my vscode terminal...