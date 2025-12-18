import java.util.Scanner;

class BasicEx1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int num;
        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE, sum = 0, cnt = 0;
        System.out.println("enter integers, enter 0 to exit");
        while (true) {
            num = read.nextInt();
            if (num == 0) break;
            lo = Math.min(lo, num);
            hi = Math.max(hi, num);
            sum += num;
            ++cnt;
        }
        System.out.printf("Average: %.3f\nLargest: %d\nSmallest: %d\n", sum / (double)cnt, hi, lo);
    }
}