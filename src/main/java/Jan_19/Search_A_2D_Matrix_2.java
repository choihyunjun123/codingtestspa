package Jan_19;

import java.util.Arrays;

public class Search_A_2D_Matrix_2 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        boolean answer = false;

        if (matrix.length == 0) {
            answer = false;
        }
        int start = 0;
        int end = matrix[start].length - 1;
        while (start < matrix.length && end >= 0) {
            if (matrix[start][end] < target) {
                start++;
            } else if (matrix[start][end] > target) {
                end--;
            } else {
                answer = true;
                break;
            }
        }
        System.out.println(answer);
    }
}
