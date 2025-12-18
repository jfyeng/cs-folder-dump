import java.util.Arrays;

class MethodEx3 {
    public static void main(String[] owo) {
        int[] cool_numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(Arrays.toString(odds(cool_numbers)));
        System.out.println(Arrays.toString(cool_numbers));
    }

    static int[] odds(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 0) continue;
            ++counter;
        }
        int[] ret = new int[counter];
        counter = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 0) continue;
            ret[counter++] = nums[i];
        }
        return ret;
    }
}
