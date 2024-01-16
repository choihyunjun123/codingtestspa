package Jan_3;

public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String s = "bacabab";
        int maxI = 0;
        int maxJ = 0;
        int maxLen = 0;
        char[] a = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (a[i] == a[j]) {
                    int start = i;
                    int end = j;
                    boolean isPalindrome = true;
                    while (start <= end) {
                        if (a[start] != a[end]) {
                            isPalindrome = false;
                            break;
                        }
                        start++;
                        end--;
                    }
                    if (isPalindrome && maxLen < j - i + 1) {
                        maxI = i;
                        maxJ = j;
                        maxLen = j - i + 1;
                    }
                }
            }
        }
        String answer = s.substring(maxI, maxJ + 1);
        System.out.println(answer);
    }
}
