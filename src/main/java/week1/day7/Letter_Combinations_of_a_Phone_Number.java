package week1.day7;

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number {
    static String[] phone = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String digits = "";

        if (digits.isEmpty()) {
            return;
        }
        List<String> answer = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        DFS(digits, 0, word, answer);
        System.out.println(answer);
    }

    private static void DFS(String digits, int i, StringBuilder word, List<String> answer) {
        if (digits.length() == i) {
            answer.add(String.valueOf(word));
            return;
        }
        String phoneWord = phone[digits.charAt(i) - '2'];
        for (char c : phoneWord.toCharArray()) {
            word.append(c);
            DFS(digits, i + 1, word, answer);
            word.deleteCharAt(i);
        }
    }


}
