package Jan_11;

import java.io.*;
import java.util.*;

public class Baek_1260 {
    static List<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(V);
    }

    private static void BFS(int v) {
        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        visited[v] = true;
        while (!que.isEmpty()) {
            int a = que.poll();
            System.out.print(a + " ");
            for (int k : A[a]) {
                if (!visited[k]) {
                    visited[k] = true;
                    que.add(k);
                }
            }
        }
    }

    private static void DFS(int v) {
        System.out.print(v + " ");
        visited[v] = true;
        for (int k : A[v]) {
            if (!visited[k]) {
                visited[k] = true;
                DFS(k);
            }
        }
    }
}
