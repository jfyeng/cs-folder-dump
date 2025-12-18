import java.util.Scanner;

class StringEx1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("4 letter words remover >> ");
        String line = kb.nextLine();
        // System.out.println(line.replaceAll("\\b\\w{4}\\b", ""));
        for (String word : line.split(" ")) {
            if (word.length() != 4) {
                System.out.print(word + " ");
            }
        }
    }
}