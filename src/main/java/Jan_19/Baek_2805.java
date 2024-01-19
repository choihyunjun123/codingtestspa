package Jan_19;

import java.io.*;
import java.util.*;

public class Baek_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long[] high = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            high[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(high);
        long bottom = 0;
        long top = high[N - 1];
        long result = 0;
        while (bottom <= top) {
            long sum = 0;
            long mid = (bottom + top) / 2;
            for (long i : high) {
                if (i > mid) {
                    sum += i - mid;
                }
            }
            if (sum >= M) {
                result = mid;
                bottom = mid + 1;
            } else {
                top = mid - 1;
            }
        }
        System.out.println(result);
    }
}
