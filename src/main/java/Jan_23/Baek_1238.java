package Jan_23;

import java.io.*;
import java.util.*;

public class Baek_1238 {
    static class Edge {
        int node, value;

        Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
        }

        int[] distanceToX = dijkstra(graph, X, N);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (i != X) {
                int[] distanceFromI = dijkstra(graph, i, N);
                max = Math.max(max, distanceFromI[X] + distanceToX[i]);
            }
        }
        System.out.println(max);
    }

    private static int[] dijkstra(ArrayList<Edge>[] graph, int start, int N) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.node;
            if (!visited[currentNode]) {
                visited[currentNode] = true;
                for (Edge edge : graph[currentNode]) {
                    if (!visited[edge.node] && distance[edge.node] > distance[currentNode] + edge.value) {
                        distance[edge.node] = distance[currentNode] + edge.value;
                        pq.add(new Edge(edge.node, distance[edge.node]));
                    }
                }
            }
        }
        return distance;
    }
}

