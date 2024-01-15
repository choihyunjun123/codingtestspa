package week1.day8;

import java.io.*;
import java.util.*;

public class Baek_9095 {
    static int answer;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        nums = new int[T];
        for (int i = 0; i < T; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < T; i++) {
            answer = 0;
            for (int j = 1; j <= 3; j++) {
                BFS(j, nums[i]);
            }
            System.out.println(answer);
        }
    }

    private static void BFS(int start, int target) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            int a = que.poll();
            if (a == target) {
                answer++;
            }
            for (int j = 1; j <= 3; j++) {
                int nextSum = a + j;
                if (nextSum <= target) {
                    que.add(nextSum);
                }
            }
        }
    }
}
