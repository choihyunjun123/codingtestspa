package Jan_9;

import java.io.*;
import java.util.*;

public class Baek_2493 {
    static class Tower {
        int height;
        int index;

        Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N + 1];
        Stack<Tower> tower = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int inputHeight = Integer.parseInt(st.nextToken());
            while (!tower.isEmpty()) {
                if (tower.peek().height >= inputHeight) {
                    answer[i] = tower.peek().index;
                    break;
                }
                tower.pop();
            }
            tower.push(new Tower(i, inputHeight));
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
