package Jan_16;

import java.io.*;

public class Baek_10026 {
    static int N;
    static String[][] map;
    static String[][] mapRG;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; // 상 우 하 좌
    static int[] dy = {-1, 0, 1, 0};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        mapRG = new String[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String color = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = String.valueOf(color.charAt(j));
                if (String.valueOf(color.charAt(j)).equals("G")) {
                    mapRG[i][j] = "R";
                } else {
                    mapRG[i][j] = String.valueOf(color.charAt(j));
                }
            }
        }
        cnt = countAreas(map);
        System.out.print(cnt);
        cnt = 0;
        visited = new boolean[N][N];
        cnt = countAreas(mapRG);
        System.out.print(" " + cnt);
    }

    private static int countAreas(String[][] currentMap) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count++;
                    DFS(i, j, currentMap);
                }
            }
        }
        return count;
    }

    private static void DFS(int x, int y, String[][] currentMap) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && yy >= 0 && xx < N && yy < N) {
                if (!visited[xx][yy] && currentMap[x][y].equals(currentMap[xx][yy])) {
                    DFS(xx, yy, currentMap);
                }
            }
        }
    }
}