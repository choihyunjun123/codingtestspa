package Jan_17;

import java.io.*;
import java.util.*;

public class Baek_2751 {
    static int[] arr, subArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        subArr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        merge(0, N - 1);
        for (int k : arr) {
            bw.write(k + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void merge(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int middle = start + (end - start) / 2;
        merge(start, middle);
        merge(middle + 1, end);
        for (int i = start; i <= end; i++) {
            subArr[i] = arr[i];
        }
        int k = start;
        int index1 = start;
        int index2 = middle + 1;
        while (index1 <= middle && index2 <= end) {
            if (subArr[index1] < subArr[index2]) {
                arr[k] = subArr[index1];
                k++;
                index1++;
            } else {
                arr[k] = subArr[index2];
                k++;
                index2++;
            }
        }
        while (index1 <= middle) {
            arr[k] = subArr[index1];
            k++;
            index1++;
        }
        while (index2 <= end) {
            arr[k] = subArr[index2];
            k++;
            index2++;
        }
    }
}
