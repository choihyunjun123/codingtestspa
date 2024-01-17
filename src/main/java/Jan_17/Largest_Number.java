package Jan_17;

import java.util.Arrays;

public class Largest_Number {
    static int[] arr;
    static String[] subArr;
    static String answer;

    public static void main(String[] args) {
        int[] nums = {0,0};
        arr = nums;
        subArr = new String[nums.length];
        answer = "";
        boolean allZero = true;
        sort(0, nums.length - 1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                allZero = false;
            }
            answer += String.valueOf(arr[i]);
        }
        if (allZero) {
            answer = "0";
        }
        System.out.println(answer);
    }

    private static void sort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int middle = start + (end - start) / 2;
        sort(start, middle);
        sort(middle + 1, end);
        int k = start;
        int index1 = start;
        int index2 = middle + 1;
        for (int i = start; i <= end; i++) {
            subArr[i] = String.valueOf(arr[i]);
        }
        while (index1 <= middle && index2 <= end) {
            String num1 = subArr[index1] + subArr[index2];
            String num2 = subArr[index2] + subArr[index1];
            if (num1.compareTo(num2) >= 0) {
                arr[k] = Integer.parseInt(subArr[index1]);
                k++;
                index1++;
            } else {
                arr[k] = Integer.parseInt(subArr[index2]);
                k++;
                index2++;
            }
        }
        while (index1 <= middle) {
            arr[k] = Integer.parseInt(subArr[index1]);
            k++;
            index1++;
        }
        while (index2 <= end) {
            arr[k] = Integer.parseInt(subArr[index2]);
            k++;
            index2++;
        }
    }
}
