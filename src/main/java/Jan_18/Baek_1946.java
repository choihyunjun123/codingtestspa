package Jan_18;

import java.io.*;
import java.util.*;

public class Baek_1946 {
    static class score implements Comparable<score> {
        int paper;
        int interview;

        score(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }

        @Override
        public int compareTo(score o) {
            return Integer.compare(this.paper, o.paper);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            score[] list = new score[N];
            for (int j = 0; j < N; j++) {
                StringTokenizer sc = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(sc.nextToken());
                int interview = Integer.parseInt(sc.nextToken());
                list[j] = new score(paper, interview);
            }
            Arrays.sort(list);
            int count = 1;
            int min = list[0].interview;
            for (int k = 1; k < N; k++) {
                if (list[k].interview < min) {
                    count++;
                    min = list[k].interview;
                }
            }
            System.out.println(count);
        }
    }
}
