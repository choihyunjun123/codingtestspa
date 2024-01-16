package Jan_16;

import java.util.*;

public class Baek_7562 {
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};   // 1 2 4 5 7 8 10 11
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int L, x, y, xx, yy;
    static int[][] coordinate;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        for (int i = 0; i < caseNum; i++) {
            L = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            xx = sc.nextInt();
            yy = sc.nextInt();
            coordinate = new int[L][L];
            visited = new boolean[L][L];
            BFS(coordinate, x, y, xx, yy);
            System.out.println(coordinate[xx][yy]);
        }
    }

    private static void BFS(int[][] coordinate, int x, int y, int targetX, int targetY) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        visited[x][y] = true;

        while (!que.isEmpty()) {
            int[] a = que.poll();
            if (a[0] == targetX && a[1] == targetY) {
                return;
            }
            for (int i = 0; i < 8; i++) {
                int xx = a[0] + dx[i];
                int yy = a[1] + dy[i];
                if (xx >= 0 && yy >= 0 && xx < coordinate.length && yy < coordinate.length) {
                    if (!visited[xx][yy]) {
                        que.add(new int[]{xx, yy});
                        visited[xx][yy] = true;
                        coordinate[xx][yy] = coordinate[a[0]][a[1]] + 1;
                    }
                }
            }
        }
    }
}
