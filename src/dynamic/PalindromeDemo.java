package dynamic;

/**
 * 求最长回文字符串
 * @author 郑凯努
 * @version 1.0
 * @date 2020/7/26
 */
public class PalindromeDemo {

    public static String longestPalindrome(String str) {
        if (str.isBlank()) {
            return str;
        }

        char[] chars = str.toCharArray();

        String palindrome = "";
        for (int i = 0; i < chars.length; i ++) {
            String palindrome1 = palindrome(chars, i, i);
            String palindrome2 = palindrome(chars, i, i + 1);
            palindrome = palindrome.length() >= palindrome1.length() ? palindrome : palindrome1;
            palindrome = palindrome.length() >= palindrome2.length() ? palindrome : palindrome2;
        }

        return palindrome;
    }

    public static String palindrome(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left --;
            right ++;
        }

        return String.copyValueOf(chars, left + 1, right - left - 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aabbac"));
    }
}
