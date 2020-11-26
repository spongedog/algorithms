package leetcode;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/11/25
 */
public class Leetcode1317 {

    public static String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int[] counters = new int[26];
        for (char c : chars) {
            counters[c - 'a'] ++;
        }

        while (sb.length() < s.length()) {
            for (int i = 0; i < counters.length; i++) {
                if (counters[i] > 0) {
                    sb.append((char)('a' + i));
                    counters[i]--;
                }
            }

            for (int i = counters.length - 1; i >= 0; i--) {
                if (counters[i] > 0) {
                    sb.append((char)('a' + i));
                    counters[i]--;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Leetcode1317.sortString("aaaabbbbcccc"));
    }
}
