import java.util.Scanner;

class PracTest12 {
    public static void main(String[] owo) {
        Scanner kb = new Scanner(System.in);

        String[] names = new String[5];
        for (int i = 0; i < 5; ++i) {
            names[i] = kb.nextLine();
        }

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (j == i) continue;

                String name1 = names[i], name2 = names[j];
                System.out.printf("%-15s", (name1 + ", " + name2));

                int score = 0;
                if (name1.charAt(0) == name2.charAt(0)) score += 5;

                for (int c1 = 0; c1 < name1.length(); ++c1) {
                    for (int c2 = 0; c2 < name2.length(); ++c2) {
                        if (c1 == 0 && c2 == 0) continue;
                        if (name1.charAt(c1) == name2.charAt(c2)) {
                            ++score;
                        }
                    }
                }
                System.out.println(" " + score);
            }
        }
    }
}