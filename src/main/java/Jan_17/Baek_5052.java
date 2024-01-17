package Jan_17;

import java.io.*;
import java.util.Arrays;

public class Baek_5052 {
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }
            Arrays.sort(arr);
            if (sort()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    private static boolean sort() {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1].startsWith(arr[i])) {
                return false;
            }
        }
        return true;
    }
}
