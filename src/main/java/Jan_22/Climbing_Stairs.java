package Jan_22;

public class Climbing_Stairs {
    public static void main(String[] args) {
        int n = 4;
        if (n == 1) {
            System.out.println(n);
        }
        int[] D = new int[n + 1];
        D[1] = 1;
        D[2] = 2;
        if (n > 2) {
            for (int i = 3; i <= n; i++) {
                D[i] = D[i - 1] + D[i - 2];
            }
        }
        System.out.println(D[n]);
    }
}
