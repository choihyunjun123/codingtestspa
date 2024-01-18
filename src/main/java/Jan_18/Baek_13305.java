package Jan_18;

import java.io.*;
import java.util.*;

public class Baek_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] length = new long[N - 1];
        int[] city = new int[N];
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }
        int start = city[0];
        for (int i = 1; i < N; i++) {
            if (city[i] < start) {
                sum += start * length[i - 1];
                start = city[i];
            } else {
                sum += start * length[i - 1];
            }
        }
        System.out.println(sum);
    }
}
