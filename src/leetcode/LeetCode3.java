package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/11/13
 */
public class LeetCode3 {

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for (char c : chars) {
            if (queue.contains(c)) {
                while (queue.contains(c)) {
                    queue.poll();
                }
            }
            queue.add(c);
            max = Math.max(max, queue.size());
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("accaabcdb"));
    }
}
