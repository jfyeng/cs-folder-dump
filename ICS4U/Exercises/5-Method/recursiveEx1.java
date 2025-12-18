import java.util.Scanner;

class recursiveEx1 {

    public static void main(String[] owo) {
        Scanner kb = new Scanner(System.in);
        String word = kb.nextLine(); // mckenzie
        anagram(word, "");
    }

    public static void anagram(String word, String picked) {
        if (word.length() == 1) {
            System.out.println(picked + word);
        }
        for (int i = 0; i < word.length(); ++i) {
            String new_word = word.substring(0, i) + word.substring(i + 1);
            anagram(new_word, picked + word.charAt(i));
        }
    }
}
