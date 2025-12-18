import java.util.Scanner;

class StringEx3 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("non-number remover >> ");
        String line = kb.nextLine();

        String ret = "";
        // for (int i = 0; i < line.length(); ++i) {
        //     if (Character.isDigit(line.charAt(i))) ret += line.charAt(i);
        // }
        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) ret += c;
        }

        try {
            int num = Integer.parseInt(ret);
            System.out.println(num);
        } catch (Exception e){
            System.out.println("Failed to convert to integer: " + e + "\n");
            // remove leading zeroes an alternative way
            while (true) {
                if (Character.isDigit(ret.charAt(0)) && ret.charAt(0) - '0' == 0) {
                    ret = ret.substring(1, ret.length());
                } else break;
            }
            System.out.println(ret);
        }
    }
}