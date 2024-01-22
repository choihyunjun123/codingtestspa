package Jan_22;

public class Maximum_Subarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

//        if (nums.length == 1) {
//            answer = nums[0];
//        }
        int max = Integer.MIN_VALUE;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current += nums[i];
            if (current > max) {
                max = current;
            }
            if (current < 0) {
                current = 0;
            }
        }
        System.out.println(max);
    }
}
