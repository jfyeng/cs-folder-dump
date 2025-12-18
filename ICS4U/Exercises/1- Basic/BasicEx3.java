import java.util.Scanner;

class BasicEx3 {
    public static void main(String[] args) {
        while (true) {
            Scanner read = new Scanner(System.in);
            System.out.print("Enter value between 1 and 50 >> ");
            int num = read.nextInt();
            if (num < 1 || num > 50) {
                System.out.println("You entered a number out of the range!");
                continue;
            }

            // 因数を見つける
            for (int i = 1; i <= Math.sqrt(num); ++i) {
                if (num % i == 0) {
                    System.out.println(i);
                    if (i != num / i) {
                        System.out.println(num / i);
                    }
                }
            }

            break;
        }
    }
}