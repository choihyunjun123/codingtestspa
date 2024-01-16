package Jan_11;

import java.util.*;

public class SubsetsDFS {
    static int[] nums = {1, 2, 3};
    static List<List<Integer>> answer;

    public static void main(String[] args) {
        answer = new ArrayList<>();
        List<Integer> subAnswer = new ArrayList<>();
        DFS(0, subAnswer);
        System.out.println(answer);
    }

    private static void DFS(int index, List<Integer> integers) {
        answer.add(new ArrayList<>(integers));
        for (int i = index; i < nums.length; i++) {
            integers.add(nums[i]);
            DFS(i + 1, integers);
            integers.remove(integers.size() - 1);
        }
    }
}
