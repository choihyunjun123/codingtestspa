package Jan_10;

import java.io.*;
import java.util.*;

public class Baek_2606 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int comNum = Integer.parseInt(br.readLine());
        int connectNum = Integer.parseInt(br.readLine());
        A = new ArrayList[comNum + 1];
        for (int i = 1; i <= comNum; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 1; i <= connectNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        visited = new boolean[comNum + 1];
        DFS(1);
        System.out.println(count);
    }

    private static void DFS(int i) {
        visited[i] = true;
        for (int k : A[i]) {
            if (!visited[k]) {
                count++;
                DFS(k);
            }
        }
    }
}
