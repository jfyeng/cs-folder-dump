import java.util.Scanner;

class StringEx2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("enter some text! >> ");
        String line = kb.nextLine();
        int len = line.length();
        int half = len/2;
        int i1 = 0, i2 = len/2;

        boolean flip = false;
        for (int i = 0; i < len/2; ++i) {
            System.out.print("" + line.charAt(i) + line.charAt(half + i));
        }

        if (len%2 == 1) System.out.print(line.charAt(len-1));
        System.out.print("\n");
    }
}