package Jan_16;

import java.util.Scanner;

public class Baek_18808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] notebook = new int[N][M];

        for (int k = 0; k < K; k++) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            int[][] sticker = new int[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = sc.nextInt();
                }
            }

            for (int rotate = 0; rotate < 4; rotate++) {
                for (int i = 0; i <= N - R; i++) {
                    for (int j = 0; j <= M - C; j++) {
                        if (canPlace(notebook, sticker, i, j)) {
                            placeSticker(notebook, sticker, i, j);
                            break;
                        }
                    }
                }

                if (countFilled(notebook) > 0) {
                    break;
                }

                sticker = rotateSticker(sticker);
            }
        }

        int result = countFilled(notebook);
        System.out.println(result);
    }

    private static int[][] rotateSticker(int[][] sticker) {
        // 90도 시계방향 회전
        int R = sticker.length;
        int C = sticker[0].length;
        int[][] rotated = new int[C][R];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                rotated[j][R - 1 - i] = sticker[i][j];
            }
        }

        return rotated;
    }

    private static boolean canPlace(int[][] notebook, int[][] sticker, int row, int col) {
        // 주어진 위치에 스티커를 붙일 수 있는지 확인
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1 && notebook[row + i][col + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void placeSticker(int[][] notebook, int[][] sticker, int row, int col) {
        // 주어진 위치에 스티커를 붙임
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1) {
                    notebook[row + i][col + j] = 1;
                }
            }
        }
    }

    private static int countFilled(int[][] notebook) {
        // 노트북에서 스티커가 붙은 칸의 수를 계산
        int count = 0;
        for (int[] row : notebook) {
            for (int cell : row) {
                count += cell;
            }
        }
        return count;
    }
}
