import java.util.*;

class Orange {
    public static void main(String[] args) {
        int[] nums = new int[10];
        int[] vals = {12, 13, 5};
        for (int i = 0; i < nums.length; ++i) {
            System.out.println(nums[i]);
        }

        for (int n : vals) {
            System.out.println(n);
        }
    }
}