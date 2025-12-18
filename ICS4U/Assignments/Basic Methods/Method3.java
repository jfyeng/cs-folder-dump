// Method3.java
// James
// A method that takes an integer array and an integer,
// then returns a copy of that array with the integer added to the end of it.

import java.util.Arrays;

class Method3 {

    public static void main(String[] owo) {
        int[] arr = { 2, 5, 13, 25, 7, 9 };
        int[] arr2 = arrayAdd(arr, 100);
        int[] arr3 = arrayAdd(arr2, -29);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }

    static int[] arrayAdd(int[] arr, int item) {
        int[] new_arr = new int[arr.length + 1];
        // copying the array over
        for (int i = 0; i < arr.length; ++i) {
            new_arr[i] = arr[i];
        }
        // adding the extra item
        new_arr[new_arr.length - 1] = item;
        return new_arr;
    }
}
