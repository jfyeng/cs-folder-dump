class MethodEx1 {
    public static void main(String[] owo) {
        int[] cool_numbers = {5, 10, 2, 7, 19, 3, 6};
        System.out.println(range(cool_numbers));
    }

    static int range(int[] nums) {
        int hi = Integer.MIN_VALUE, lo = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            hi = Math.max(hi, nums[i]);
            lo = Math.min(lo, nums[i]);
        }
        return hi - lo;
    }
}