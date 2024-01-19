package Jan_19;

import java.io.*;
import java.util.*;

public class Baek_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] want = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            want[i] = Integer.parseInt(st.nextToken());
            sum += want[i];
        }
        int M = Integer.parseInt(br.readLine());
        Arrays.sort(want);
        if (sum <= M) {
            System.out.println(want[N - 1]);
        } else {
            int left = 0;
            int right = want[N - 1];
            int result = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                sum = 0;
                for (int i = 0; i < N; i++) {
                    if (want[i] > mid) {
                        sum += mid;
                    } else {
                        sum += want[i];
                    }
                }
                if (sum > M) {
                    right = mid - 1;
                } else {
                    result = mid;
                    left = mid + 1;
                }
            }
            System.out.println(result);
        }
    }
}
