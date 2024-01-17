package Jan_17;

import java.io.*;
import java.util.*;

public class Baek_2108 {
    static int[] arr, subArr;
    static int sum, avg, mid, most, range;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        subArr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        sort(0, N - 1);
        sum = 0;
        for (int i : arr) {
            sum += i;
        }
        avg = Math.round((float) sum / N);
        mid = arr[N / 2];
        most = findMid();
        range = arr[N - 1] - arr[0];
        System.out.println(avg);
        System.out.println(mid);
        System.out.println(most);
        System.out.println(range);
    }

    private static void sort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int middle = start + (end - start) / 2;
        sort(start, middle);
        sort(middle + 1, end);
        int k = start;
        int index1 = start;
        int index2 = middle + 1;
        for (int i = start; i <= end; i++) {
            subArr[i] = arr[i];
        }
        while (index1 <= middle && index2 <= end) {
            if (subArr[index1] <= subArr[index2]) {
                arr[k++] = subArr[index1++];
            } else {
                arr[k++] = subArr[index2++];
            }
        }
        while (index1 <= middle) {
            arr[k++] = subArr[index1++];
        }
        while (index2 <= end) {
            arr[k++] = subArr[index2++];
        }
    }

    private static int findMid() {
        int start = arr[0];
        Deque<Integer> que = new LinkedList<>();
        que.addLast(start);
        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                count++;
            } else {
                count = 1;
            }
            if (count > maxCount) {
                maxCount = count;
                while (!que.isEmpty()) {
                    que.poll();
                }
                que.push(arr[i]);
            } else if (count == maxCount) {
                que.push(arr[i]);
            }
        }
        if (que.size() > 1) {
            que.pollLast();
            start = que.pollLast();
        } else {
            start = que.pollLast();
        }
        return start;
    }
}
