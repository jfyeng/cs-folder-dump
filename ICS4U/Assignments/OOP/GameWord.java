// GameWord.java
// James
// A class called GameWord, intended to be used as part of a bigger game.
// It can reverse its given word, check if its word and a given word are anagrams of each other,
// calculate its word score given coordinates and a direction, and find all permutations of the letters in its word.

import java.util.ArrayList;
import java.util.HashMap;

class GameWord {
    
    // -- FIELDS --
    // stores the base values of all the characters in the alphabet
    HashMap<Character, Integer> base_values = new HashMap<Character, Integer>(){{
        put('E', 1); put('A', 1); put('I', 1); put('O', 1); put('N', 1); put('R', 1); put('T', 1); put('L', 1); put('S', 1); put('U', 1);
        put('D', 2); put('G', 2);
        put('B', 3); put('C', 3); put('M', 3); put('P', 3);
        put('F', 4); put('H', 4); put('V', 4); put('W', 4); put('Y', 4);
        put('K', 5);
        put('J', 8); put('X', 8);
        put('Q', 10); put('Z', 10);
    }};
    // constant directions predefined for accessibility
    public static final int RIGHT = 1, DOWN = 2;
    // the word this class contains
    public String contents = "";

    // the board of scrabble and all its bonuses
    // 0 = nothing, 1 = double letter score, 2 = triple letter score, 3 = double word score, 4 = triple word score
    int[][] bonuses = {
        {4,0,0,1,0,0,0,4,0,0,0,1,0,0,4},
        {0,3,0,0,0,2,0,0,0,2,0,0,0,3,0},
        {0,0,3,0,0,0,1,0,1,0,0,0,3,0,0},
        {1,0,0,3,0,0,0,1,0,0,0,3,0,0,1},
        {0,0,0,0,3,0,0,0,0,0,3,0,0,0,0},
        {0,2,0,0,0,2,0,0,0,2,0,0,0,2,0},
        {0,0,1,0,0,0,1,0,1,0,0,0,1,0,0},
        {4,0,0,1,0,0,0,0,0,0,0,1,0,0,4},
        {0,0,1,0,0,0,1,0,1,0,0,0,1,0,0},
        {0,2,0,0,0,2,0,0,0,2,0,0,0,2,0},
        {0,0,0,0,3,0,0,0,0,0,3,0,0,0,0},
        {1,0,0,3,0,0,0,1,0,0,0,3,0,0,1},
        {0,0,3,0,0,0,1,0,1,0,0,0,3,0,0},
        {0,3,0,0,0,2,0,0,0,2,0,0,0,3,0},
        {4,0,0,1,0,0,0,4,0,0,0,1,0,0,4},
    };

    // -- METHODS --

    // constructor method to set contents to the right value
    public GameWord(String contents) {
        this.contents = contents.toUpperCase(); // I don't think scrabble is even case sensitive anyway.
    }

    // return a reversed version of the contents string
    public String reverse() {
        String reversed = "";
        for (char c : contents.toCharArray()) {
            reversed = c + reversed;
        }
        return caseFix(reversed);
    }

    // returns if a given word can be the anagram of the contents string of this class
    public boolean anagram(String other_word) {
        return anaCheck(contents, other_word);
    }

    // overload for given another gameword instead
    public boolean anagram(GameWord other_GameWord) {
        return anaCheck(contents, other_GameWord.contents);
    }

    // returns the point score of the current word given a position and direction
    // this method doesn't check for bounds
    // 0 = nothing, 1 = double letter score, 2 = triple letter score, 3 = double word score, 4 = triple word score
    public int pointValue(int x, int y, int direction) {
        int word_multiplier = 1;
        int[] letter_multiplier = new int[contents.length()]; // store letter multipliers
        for (int i = 0; i < contents.length(); ++i) {
            if (bonuses[y][x] == 1) letter_multiplier[i] = 2;
            else if (bonuses[y][x] == 2) letter_multiplier[i] = 3;
            else {
                letter_multiplier[i] = 1;
                if (bonuses[y][x] == 3) word_multiplier *= 2;
                if (bonuses[y][x] == 4) word_multiplier *= 3;
            }

            // increment to get the next square
            if (direction == 0) x++;
            else if (direction == 1) y++;
        }

        // apply letter multipliers and sum up the score
        int score = 0;
        for (int i = 0; i < contents.length(); ++i) {
            score += base_values.get(contents.charAt(i)) * letter_multiplier[i];
        }
        // apply word multiplier
        score *= word_multiplier;

        return score;
    }

    private ArrayList<String> perms = new ArrayList<String>();
    // returns an ArrayList of all the permutations of the current contents string
    public ArrayList<String> permutations() {
        perms.clear();
        permutations(this.contents, "");
        return perms;
    }
    // private method used recursively to find permutations
    private void permutations(String word, String picked) {
        if (word.length() == 0) { // base case: no more characters left to add
            perms.add(caseFix(picked));
        }
        for (int i = 0; i < word.length(); ++i) { // recurse case: add char from word to picked
            permutations(word.substring(0, i) + word.substring(i+1, word.length()), picked + word.charAt(i));
        }
    }

    // output the contents string variable thingamajig
    public String toString() {
        return caseFix(contents);
    }


    // -- GENERAL UTILITY -- 
    
    // check if two strings are an anagram
    private boolean anaCheck(String a, String b) {
        if (a.length() != b.length()) return false;
        // make sure it's not case sensitive
        a = a.toUpperCase();
        b = b.toUpperCase();
        boolean[] used = new boolean[b.length()];
        int match = 0;
        for (char c : a.toCharArray()) {
            for (int i = 0; i < b.length(); ++i) {
                if (b.charAt(i) == c && !used[i]) {
                    used[i] = true;
                    ++match;
                    break;
                }
            }
        }
        if (match != a.length()) return false;
        return true;
    }

    // fix the cases to match the desired output from the test program's comments
    private String caseFix(String s) {
        return s.toLowerCase();
    }

}