package Jan_10;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> subAnswer = new ArrayList<>();
        boolean[] visited = new boolean[num.length];
        DFS(num, answer, subAnswer, visited);
        System.out.println(answer);
    }

    private static void DFS(int[] num, List<List<Integer>> answer, List<Integer> subAnswer, boolean[] visited) {
        if (subAnswer.size() == num.length) {
            answer.add(new ArrayList<>(subAnswer));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                subAnswer.add(num[i]);
                DFS(num, answer, subAnswer, visited);
                visited[i] = false;
                subAnswer.remove(subAnswer.size() - 1);
            }
        }
    }
}
