package Jan_10;

import java.util.*;

public class Combination {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        List<List<Integer>> answer = new ArrayList<>();
        DFS(n, k, answer, new ArrayList<>(),0);
        System.out.println(answer);
    }
    private static void DFS(int n, int k, List<List<Integer>> answer, List<Integer> subAnswer, int index) {
        if (subAnswer.size() == k) {
            answer.add(new ArrayList<>(subAnswer));
            return;
        }
        for (int i = index; i < n; i++) {
            subAnswer.add(i + 1);
            DFS(n, k, answer, subAnswer, ++index);
            subAnswer.remove(subAnswer.size() - 1);
        }
    }
}
