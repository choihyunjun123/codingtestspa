package Jan_23;

import java.io.*;
import java.util.*;

public class Baek_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > 0) {
                positive.add(arr[i]);
            } else {
                negative.add(arr[i]);
            }
        }
        positive.sort(Collections.reverseOrder());
        Collections.sort(negative);
        int sum = 0;
        int maxDistance = 0;
        if (!positive.isEmpty() && !negative.isEmpty()) {
            maxDistance = Math.max(positive.get(0), -negative.get(0));
        } else if (!positive.isEmpty()) {
            maxDistance = positive.get(0);
        } else if (!negative.isEmpty()) {
            maxDistance = -negative.get(0);
        }
        for (int i = 0; i < positive.size(); i += M) {
            sum += positive.get(i) * 2;
        }
        for (int i = 0; i < negative.size(); i += M) {
            sum += -negative.get(i) * 2;
        }
        sum -= maxDistance;
        System.out.println(sum);
    }
}
