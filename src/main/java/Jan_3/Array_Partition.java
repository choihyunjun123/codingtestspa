package Jan_3;

import java.util.Arrays;

public class Array_Partition {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        System.out.println(sum);
    }
}
