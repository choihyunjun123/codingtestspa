package Jan_19;

import java.util.Arrays;

public class Two_Sum_2 {
    public static void main(String[] args) {
        int[] numbers = {-1,0};
        int target = -1;
        int[] answer = new int[2];

        int start = 0;
        int end = numbers.length - 1;
        while (start <= end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                answer[0] = start + 1;
                answer[1] = end + 1;
                break;
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
