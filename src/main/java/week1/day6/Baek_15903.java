package week1.day6;

import java.io.*;
import java.util.*;

public class Baek_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> card = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card.offer(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            long sum = card.poll() + card.poll();
            card.offer(sum);
            card.offer(sum);
        }
        long totalSum = 0;
        while (!card.isEmpty()) {
            totalSum += card.poll();
        }
        System.out.println(totalSum);
    }
}
