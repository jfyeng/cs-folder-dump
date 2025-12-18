import java.util.Scanner;

class recursiveEx2 {

    public static void main(String[] owo) {
        Scanner kb = new Scanner(System.in);
        String word = kb.nextLine(); // mckenzie
        everyCapital(word, "");
    }

    static void everyCapital(String word, String capped) {
        if (word.length() == 1) {
            System.out.println(capped + word.toLowerCase());
            System.out.println(capped + word.toUpperCase());
            return;
        }
        String new_word = word.substring(1, word.length());
        String to_cap = word.substring(0, 1);
        everyCapital(new_word, capped + to_cap.toLowerCase());
        everyCapital(new_word, capped + to_cap.toUpperCase());
    }
}
