package Jan_8;

import java.io.*;
import java.util.*;

public class Baek_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            char[] input = br.readLine().toCharArray();
            LinkedList<Character> answer = new LinkedList<>();
            LinkedList<Character> cursor = new LinkedList<>();
            for (char c : input) {
                if (c == '<') {
                    if (!answer.isEmpty()) {
                        cursor.offerFirst(answer.removeLast());
                    }
                } else if (c == '>') {
                    if (!cursor.isEmpty()) {
                        answer.offerLast(cursor.pollFirst());
                    }
                } else if (c == '-') {
                    if (!answer.isEmpty()) {
                        answer.removeLast();
                    }
                } else {
                    answer.offerLast(c);
                }
            }
            StringBuilder result = new StringBuilder();
            while (!answer.isEmpty()) {
                result.append(answer.pollFirst());
            }
            while (!cursor.isEmpty()) {
                result.append(cursor.pollFirst());
            }
            System.out.println(result);
        }
    }
}
