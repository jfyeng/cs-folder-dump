
// HashAssign1
// James Feng
// Given a string of letters, returns all words you can make using only those letters, according to a dictionary text file.

import java.io.*;
import java.util.Scanner;

class HashAssign1 {

    public static void main(String[] args) {
        HashTable<String> dictionary = new HashTable<String>();

        // reading from file
        try {
            File file = new File("dictionary.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                dictionary.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // INPUT
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter letters: ");
        String letters = kb.nextLine().strip().toLowerCase();
        kb.close();

        // generate permutations of the given letters
        HashTable<String> perms = new HashTable<String>();
        anagram(letters, "", perms);

        // check all permutations to see if they are in the dictionary
        for (String s : perms.toArray()) {
            if (dictionary.contains(s)) {
                System.out.println(s);
            }
        }

    }

    // generate permutations
    private static void anagram(String word, String picked, HashTable<String> stash) {
        if (word.length() == 1) {
            if (!stash.contains(picked + word)) stash.add(picked + word);
        }
        for (int i = 0; i < word.length(); ++i) {
            String new_word = word.substring(0, i) + word.substring(i + 1);
            anagram(new_word, picked + word.charAt(i), stash);
        }
    }

}