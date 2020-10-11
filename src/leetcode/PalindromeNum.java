package leetcode;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/9/30
 */
public class PalindromeNum {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int res = 0;
        int source = x;
        while (source != 0) {
            int pop = source % 10;
            source /= 10;
            res = res * 10 + pop;
        }

        return res == x;
    }

    public static void main(String[] args) {
        System.out.println(PalindromeNum.isPalindrome(-121));
    }
}
