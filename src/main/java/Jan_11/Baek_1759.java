package Jan_11;

import java.util.*;

public class Baek_1759 {
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static int L, C;
    static char[] characters;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        L = scanner.nextInt();
        C = scanner.nextInt();
        characters = new char[C];
        for (int i = 0; i < C; i++) {
            characters[i] = scanner.next().charAt(0);
        }
        Arrays.sort(characters);
        generatePassword(0, 0, "");
        scanner.close();
    }

    private static void generatePassword(int index, int vowelCount, String currentPassword) {
        if (currentPassword.length() == L) {
            if (vowelCount >= 1 && (L - vowelCount) >= 2) {
                System.out.println(currentPassword);
            }
            return;
        }
        for (int i = index; i < C; i++) {
            int newVowelCount = isVowel(characters[i]) ? vowelCount + 1 : vowelCount;
            generatePassword(i + 1, newVowelCount, currentPassword + characters[i]);
        }
    }

    private static boolean isVowel(char c) {
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }
}
