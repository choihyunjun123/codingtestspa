package Jan_18;

import java.io.*;
import java.util.*;

public class Baek_1931 {

    static class room {
        int start, end;

        room(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        room[] arr = new room[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer sc = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(sc.nextToken());
            int b = Integer.parseInt(sc.nextToken());
            arr[i] = new room(a, b);
        }
        Arrays.sort(arr, new Comparator<room>() {
            @Override
            public int compare(room o1, room o2) {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });
        int count = 1;
        int last = arr[0].end;
        for (int i = 1; i < N; i++) {
            if (arr[i].start >= last) {
                last = arr[i].end;
                count++;
            }
        }
        System.out.println(count);
    }
}
