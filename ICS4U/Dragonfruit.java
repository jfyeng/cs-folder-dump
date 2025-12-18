// learn garbage collectors
// learn memory nuances
// learn how stuff works, more technically
// DO NOT ALLOW UNWANTED SIDE EFFECTS IN YOUR METHODS!!

import java.util.Arrays;

class Dragonfruit {
    public static void main(String[] owo) {
        String name = "Leo";
        doctorfy(name);
        System.out.println(name);
        System.out.println(avg(2, 5));
        int[] vals = fill(10, 3);
        System.out.println(Arrays.toString(vals));
    }

    // this doesn't change the original "name" variable because strings are immutable in java. when you concatenate and stuff, it's making a new string.
    // stringbuilder is mutable
    static void doctorfy(String name) {
        name = "Dr. " + name;
        System.out.println(name);
    }

    static int[] fill(int size, int val) {
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = val;
        }
        return ans;
    }

    static int avg(int a, int b) {
        return (a+b)/2;
    }
}

// class Dragonfruit {
//     public static void main(String[] owo) {
//         hi();
//         hi("Leo");
//         int x = 10;
//         addone(x);
//         System.out.println(x);
//         int[] nums = {2, 6, 8};
//         addone(nums);
//         for (int i = 0; i < nums.length; ++i) {
//             System.out.println(nums[i]);
//         }
//     }

//     // method overloading
//     // - 2 or more methods with the same name but different parameter signatures
//     static void hi() {
//         System.out.println("hi");
//     }
//     static void hi(String str) {
//         System.out.println("hi " + str);
//     }

//     // Parameters in java are "Call by value" 
//     // when parameter is changed, argument is not.
//     static void addone(int x) {
//         x++;
//     }
//     static void addone(int[] vals) {
//         for (int i = 0; i < vals.length; ++i) {
//             vals[i]++;
//         }
//     }
// }