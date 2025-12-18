import java.util.Scanner;

class ArrayEx1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("This program gets grades, gets the average, and tells you the difference between each grade and the average.");
        System.out.printf("Enter some space-separated grades 0-100 >> ");
        String[] string_grades = s.nextLine().split(" ");
        int count = string_grades.length;
        double[] grades = new double[count];

        for (int i = 0; i < count; ++i) {
            grades[i] = Double.parseDouble(string_grades[i]);
        }

        double sum = 0;
        for (int i = 0; i < count; ++i) {
            sum += grades[i];
        }
        double avg = sum / count;

        System.out.printf("Average: %.1f\n", avg);
        for (int i = 0; i < count; ++i) {
            System.out.printf("%5.1f | %s %5.1f\n", grades[i], (grades[i] - avg) >= 0? "+" : "-", Math.abs(grades[i] - avg));
        }
    }
}