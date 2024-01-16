package Jan_3;

import java.util.*;

public class Baek_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            answer.add(c);
        }
        for (int i = 97; i <= 122; i++) {
            if (answer.contains(i)) {
                System.out.print(answer.indexOf(i) + " ");
            } else {
                System.out.print(-1 + " ");
            }
        }
    }
}
