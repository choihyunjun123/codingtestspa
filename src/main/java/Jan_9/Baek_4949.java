package Jan_9;

import java.io.*;
import java.util.*;

public class Baek_4949 {
    public static void main(String[] args) throws IOException {
        Deque<String> sentences = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        while (!word.equals(".")) {
            sentences.push(word);
            word = br.readLine();
        }
        while (!sentences.isEmpty()) {
            String sentence = sentences.pollLast();
            if (isBalanced(sentence)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isBalanced(String sentence) {
        Stack<Character> check = new Stack<>();
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == '(' || c == '[') {
                check.push(c);
            } else if (c == ')' || c == ']') {
                if (check.isEmpty() ||
                        (check.peek() == '(' && c == ']') ||
                        (check.peek() == '[' && c == ')')) {
                    return false;
                }
                check.pop();
            }
        }
        return check.isEmpty();
    }
}
