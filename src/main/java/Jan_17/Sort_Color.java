package Jan_17;

import java.util.Arrays;

public class Sort_Color {
    static int[] subNums;

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        subNums = new int[nums.length];
        sort(nums, 0,nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums, int start, int end) {
        if (end - start < 1) {
            return;
        }
        int middle = start + (end - start) / 2;
        sort(nums, start, middle);
        sort(nums, middle + 1, end);
        int k = start;
        int index1 = start;
        int index2 = middle + 1;
        for (int i = start; i <= end; i++) {
            subNums[i] = nums[i];
        }
        while (index1 <= middle && index2 <= end) {
            if (subNums[index1] <= subNums[index2]) {
                nums[k++] = subNums[index1++];
            } else {
                nums[k++] = subNums[index2++];
            }
        }
        while (index1 <= middle) {
            nums[k++] = subNums[index1++];
        }
        while (index2 <= end) {
            nums[k++] = subNums[index2++];
        }
    }
}
