// RealTest12c.java
// James

import java.util.Scanner;

class RealTest12c {
    public static void main(String[] owo) {
        System.out.println("Enter Sentence: ");
        Scanner kb = new Scanner(System.in);

        String line = kb.nextLine();
        int final_num = 1;
        boolean null_flag = true;
        for (int i = 0; i < line.length(); ++i) {
            String sub = "";
            if (Character.isDigit(line.charAt(i))) {
                while (i < line.length()) {
                    if (!Character.isDigit(line.charAt(i))) break;
                    sub += line.charAt(i);
                    ++i;
                }
            }
            if (sub.length() > 0) {
                null_flag = false;
                final_num *= Integer.parseInt(sub);
                // System.out.print(sub + " ");
            }
        }

        // System.out.println("\n" + final_num);

        String strfn = Integer.toString(final_num); // string_final_num (strfn)

        if (null_flag) strfn = "";
        while (strfn.length() < 4) {
            strfn = "0" + strfn;
        }
        // System.out.println("PIN: " + strfn.substring(strfn.length()-4, strfn.length()));
        System.out.println("PIN: " + Integer.parseInt(strfn.substring(strfn.length()-4, strfn.length())));
    }
}