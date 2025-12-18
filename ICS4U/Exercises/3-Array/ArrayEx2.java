import java.util.Scanner;

class ArrayEx2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("This program advances any day references by 1 in a given text. Ex. Monday -> Tuesday");
        System.out.print("Enter some text >> ");

        String line = s.nextLine();
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String result_string = "";

        for (int i = 0; i < days.length; ++i) {
            line = line.replaceAll("(?i)" + days[i], "<{" + (i+1)%days.length + "}>");
        }
        for (int i = 0; i < days.length; ++i) {
            line = line.replace("<{" + i + "}>", days[i]);
        }
        System.out.println(line);
    }
}