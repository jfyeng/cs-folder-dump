import java.util.Scanner;

class recursiveEx3 {

    public static void main(String[] owo) {
        Scanner kb = new Scanner(System.in);
        int decimal_num = kb.nextInt();
        boolean sign = decimal_num < 0;
        if (sign) decimal_num = -decimal_num;
        if (sign) System.out.print("-");
        if (decimal_num == 0) System.out.println("0");
        else System.out.println(toBinary(decimal_num));
    }

    static String toBinary(int num) {
        if (num == 0) return "";
        if (num % 2 == 1) {
            return toBinary((num - 1) / 2) + "1";
        } else {
            return toBinary(num / 2) + "0";
        }
    }
}
