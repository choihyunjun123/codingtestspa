package Jan_10;

import java.io.*;
import java.util.*;

public class Baek_2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; // 상 우 하 좌
    static int[] dy = {-1, 0, 1, 0};
    static int cnt = 0;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String nums = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = nums.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    DFS(i, j);
                    answer.add(cnt);
                }
            }
        }
        System.out.println(answer);
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx >= 0 && yy >= 0 && xx < N && yy < N) {
                if (map[xx][yy] == 1 && !visited[xx][yy]) {
                    DFS(xx, yy);
                }
            }
        }
    }
}
