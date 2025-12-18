// Method4.java
// James
// A method that takes an array of integers, then makes a new array half the size.
// The new array's values are the old array's two halves added together.

import java.util.Arrays;

class Method4 {

    public static void main(String[] owo) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] arr2 = fold(arr);
        System.out.println(Arrays.toString(arr2));
    }

    static int[] fold(int[] nums) {
        int[] new_arr = new int[nums.length / 2];
        // iterate over half of the array, and use len/2 + i to get the other half, then add them together
        // to get the value in the new array
        for (int i = 0; i < nums.length / 2; ++i) {
            new_arr[i] = nums[i] + nums[i + (nums.length / 2)];
        }
        return new_arr;
    }
}
