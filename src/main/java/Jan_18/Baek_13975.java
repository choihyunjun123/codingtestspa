package Jan_18;

import java.io.*;
import java.util.*;

public class Baek_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> que = new PriorityQueue<>();
            for (int j = 0; j < K; j++) {
                que.add(Long.valueOf(st.nextToken()));
            }
            long sum = 0;
            for (int s = 0; s < K - 1; s++) {
                long a = que.poll();
                long b = que.poll();
                sum += a + b;
                que.add(a + b);
            }
            System.out.println(sum);
        }

    }
}
