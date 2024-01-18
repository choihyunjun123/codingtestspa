package Jan_18;

import java.io.*;
import java.util.*;

public class Baek_11000 {
    static class time {
        int start, end;

        time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        time[] list = new time[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[i] = new time(a, b);
        }
        Arrays.sort(list, new Comparator<time>() {
            @Override
            public int compare(time o1, time o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        });
        int count = 1;
        PriorityQueue<Integer> answer = new PriorityQueue<>();
        answer.add(list[0].end);
        for (int i = 1; i < N; i++) {
            if (list[i].start >= answer.peek()) {
                answer.poll();
                answer.add(list[i].end);
            } else {
                answer.add(list[i].end);
                count++;
            }
        }
        System.out.println(count);
    }
}
