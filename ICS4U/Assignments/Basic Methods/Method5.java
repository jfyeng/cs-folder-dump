// Method5.java
// James
// A method that generates a license plate consisting of 4 capital letters, a space, then 3 digits,
// and makes sure the generated plate doesn't contain a word on the ban list.
// Commented out is some code to make a bigger ban list, for testing purposes.

import java.util.Random;

class Method5 {

    public static void main(String[] owo) {
        // String[] ban_list = wordGen(500000);
        String[] ban_list = { "WORK", "FAIL", "AAAA", "BBBB", "CCCC" };
        System.out.println(licensePlate(ban_list));
    }

    // generate a bigger list for testing purposes
    static String[] wordGen(int amount) {
        String[] words = new String[amount];
        for (int i = 0; i < amount; ++i) {
            words[i] = generateWord();
        }
        return words;
    }

    static String licensePlate(String[] words) {
        String plate;
        boolean flag = false;
        while (true) {
            flag = false;
            plate = generateWord();
            // checking if the word matches with any word in the ban list
            for (int i = 0; i < words.length && !flag; ++i) {
                if (plate.equals(words[i])) {
                    // System.out.printf("Matched with %s\n", words[i]);
                    flag = true;
                }
            }
            if (!flag) break;
        }

        // generate the number. no restrictions on the number
        // there may be leading zeroes
        Random rand = new Random();
        plate += " ";
        for (int i = 0; i < 3; ++i) {
            plate += (char) ('0' + rand.nextInt(10));
        }

        return plate;
    }

    // a handy method to generate a new word
    static String generateWord() {
        Random rand = new Random();
        String word = "";
        for (int i = 0; i < 4; ++i) {
            word += (char)('A' + rand.nextInt(26));
        }
        return word;
    }

}
