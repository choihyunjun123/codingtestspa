package Jan_19;

import java.io.*;
import java.util.*;

public class Baek_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long start = 1;
        long end = arr[K - 1];
        long result = 0;
        while (start <= end) {
            long count = 0;
            long mid = (start + end) / 2;
            for (long i : arr) {
                count += i / mid;
            }
            if (count >= N) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
