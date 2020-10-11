package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 316
 * @author 郑凯努
 * @version 1.0
 * @date 2020/10/9
 */
public class RemoveDuplicateChar {

    public String removeDuplicateLetters(String s) {
        Deque<Character> characterStack = new LinkedList<>();
        //标记字符是否已出现在栈中
        boolean[] inStack = new boolean[256];
        int[] counts = new int[256];
        s.chars().forEach(c -> counts[c] ++);

        s.chars().forEach(c -> {
            counts[c] --;
            if (inStack[c]) {
                return;
            }

            while (!characterStack.isEmpty() && characterStack.peek() < c) {
                if (counts[characterStack.peek()] == 0) {
                    break;
                }

                inStack[characterStack.pop()] = false;
            }
            characterStack.push((char) c);
            inStack[c] = true;
        });

        StringBuilder stringBuilder = new StringBuilder();
        characterStack.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateChar().removeDuplicateLetters("abcbda"));
    }
}
