import java.util.Scanner;

class BasicEx5 {
    public static void main(String[] args) {
        while (true) {
            Scanner read = new Scanner(System.in);
            System.out.print("Enter number >> ");
            int num = read.nextInt();
            if (num < 0) {
                System.out.println("Negative factorials are undefined!");
                continue;
            }
            System.out.println(refac(num));

            break;
        }
    }
    static int refac(int n) {
        if (n == 0) return (int)1;
        if (n == 1) return (int)1;
        return n * refac(n-1);
    }
}