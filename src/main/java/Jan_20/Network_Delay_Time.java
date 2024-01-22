package Jan_20;

import java.util.*;

public class Network_Delay_Time {
    public static void main(String[] args) {
//        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int[][] times = {{1,2,1}};
        int n = 2;
        int k = 1;
        System.out.println(networkDelayTime(times, n, k));
    }

    static class Edge implements Comparable<Edge> {
        int node, value;

        Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.value > o.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> arr = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        PriorityQueue<Edge> que = new PriorityQueue<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }
        for (int[] time : times) {
            arr.get(time[0]).add(new Edge(time[1], time[2]));
        }
        que.add(new Edge(k, 0));
        distance[k] = 0;
        while (!que.isEmpty()) {
            Edge current = que.poll();
            int cv = current.node;
            if (visited[cv]) {
                continue;
            }
            visited[cv] = true;
            for (int i = 0; i < arr.get(cv).size(); i++) {
                Edge tmp = arr.get(cv).get(i);
                int next = tmp.node;
                int value = tmp.value;
                if (distance[next] > value + distance[cv]) {
                    distance[next] = value + distance[cv];
                    que.add(new Edge(next, distance[next]));
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] > max) {
                max = distance[i];
            }
        }
        boolean hi = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                hi = false;
            }
        }
        if (hi) {
            return max;
        } else {
            return -1;
        }
    }
}
