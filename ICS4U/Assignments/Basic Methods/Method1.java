// Method1.java
// James
// A method that takes an integer array, and returns the mean of the integers in the array.

class Method1 {

    public static void main(String[] owo) {
        int[] cool_arr = { 5, 7, 2, 8, 10, 15, 2, 13, 22, 234, 230, 490, 6903 };
        System.out.println(mean(cool_arr));
    }

    static double mean(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (double) sum / nums.length;
    }
}
