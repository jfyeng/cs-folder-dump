// RealTest12.java
// James
// Given a string of text, this program cuts the words in half,
// reverses the order of the halves, adds a comma in between, and capitalizes the first letter.

import java.util.Scanner;

class RealTest12 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String[] words = kb.nextLine().split(" ");
        int a = words.length - (words.length / 2);
        String result = "";
        for (int i = a; i < words.length; ++i) {
            result += words[i] + (i + 1 < words.length? " " : "");
        }
        result += ", ";
        for (int i = 0; i < a; ++i) {
            result += words[i] + " ";
        }
        result = Character.toUpperCase(result.charAt(0)) + result.substring(1, result.length());
        System.out.println(result);
    }
}