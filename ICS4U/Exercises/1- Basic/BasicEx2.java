import java.util.Scanner;

class BasicEx2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter base value >> ");
        int base = read.nextInt();
        System.out.print("Enter term count >> ");
        int term_count = read.nextInt();
        int ans = 0;
        for (int i = 0; i < term_count; ++i) {
            ans += Math.pow(base, i);
        }
        System.out.println(ans);
    }
}