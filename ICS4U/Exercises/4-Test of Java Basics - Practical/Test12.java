import java.util.Scanner;

class Test12 {
    public static void main(String[] owo) {
        Scanner kb = new Scanner(System.in);

        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String[] date1 = kb.nextLine().split("/");
        String[] date2 = kb.nextLine().split("/");

        int date1_int = Integer.parseInt(date1[0]);
        for (int i = 0; i < Integer.parseInt(date1[1])-1; ++i) {
            date1_int += months[i];
        }
        int date2_int = Integer.parseInt(date2[0]);
        for (int i = 0; i < Integer.parseInt(date2[1])-1; ++i) {
            date2_int += months[i];
        }

        System.out.println("Days between: " + Math.abs(date1_int - date2_int));
        // System.out.println(date1_int + " " + date2_int);
    }
}