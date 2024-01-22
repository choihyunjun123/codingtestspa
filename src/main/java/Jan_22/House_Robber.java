package Jan_22;

import java.util.Arrays;

public class House_Robber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] D = new int[n];
        D[0] = nums[0];
        D[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            D[i] = Math.max(D[i - 1], D[i - 2] + nums[i]);
        }
        System.out.println(Arrays.toString(D));
        return D[n - 1];
    }
}
