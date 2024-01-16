package Jan_9;

import java.io.*;
import java.util.*;

public class Baek_2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<String> start = new LinkedList<>();
        Deque<String> end = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            start.push(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            end.push(br.readLine());
        }
        int answer = 0;
        while (!end.isEmpty()) {
            String expectedCar = start.peekLast();
            String actualCar = end.peekLast();
            if (expectedCar.equals(actualCar)) {
                start.removeLast();
                end.removeLast();
            } else {
                answer++;
                end.removeLast();
                start.remove(actualCar);
            }
        }
        System.out.println(answer);
    }
}
