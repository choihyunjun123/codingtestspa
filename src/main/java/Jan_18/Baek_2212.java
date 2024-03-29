package Jan_18;

import java.util.*;

public class Baek_2212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        Integer[] len = new Integer[N - 1];
        for (int i = 0; i < N - 1; i++) {
            len[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(len, Collections.reverseOrder());
        int sum = 0;
        for (int i = K - 1; i < N - 1; i++) {
            sum += len[i];
        }
        System.out.println(sum);
    }
}
