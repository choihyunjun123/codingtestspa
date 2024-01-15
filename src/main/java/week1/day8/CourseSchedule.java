package week1.day8;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        boolean result = canFinsh(numCourses, prerequisites);
        System.out.println(result);
    }

    private static boolean canFinsh(int numCourses, int[][] prerequisites) {
        List<List<Integer>> numList = new ArrayList<>();
        int[] numGetLine = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            numList.add(new ArrayList<>());
        }
        for (int[] i : prerequisites) {
            int a = i[0];
            int b = i[1];
            numList.get(a).add(b);
            numGetLine[b]++;
        }
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (numGetLine[i] == 0) {
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int aa = que.poll();
            for (int k : numList.get(aa)) {
                numGetLine[k]--;
                if (numGetLine[k] == 0) {
                    que.offer(k);
                }
            }
        }

        for (int a : numGetLine) {
            if (a != 0) {
                return false;
            }
        }
        return true;
    }
}
