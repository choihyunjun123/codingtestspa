package Jan_23;

import java.util.*;
import java.io.*;

public class Baek_1939 {
    static class Node {
        int end, limit;

        Node(int end, int limit) {
            this.end = end;
            this.limit = limit;
        }
    }

    static int start, end;
    static int max = 1000000000, min = 1;
    static ArrayList<Node>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, c));
            arr[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        while (max >= min) {
            int mid = (min + max) / 2;
            if (BFS(mid)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }

    private static boolean BFS(int mid) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        while (!que.isEmpty()) {
            int now = que.poll();
            if (now == end) {
                return true;
            }
            for (Node k : arr[now]) {
                if (!visited[k.end] && k.limit >= mid) {
                    visited[k.end] = true;
                    que.add(k.end);
                }
            }
        }
        return false;
    }
}

