package dynamic;

/**
 * 负数无效
 * @author 郑凯努
 * @version 1.0
 * @date 2020/7/23
 */
public class NumberOf1Demo {

    public static int NumberOf1(int n) {
        int numOf1 = 0;
        while ((n = n & (n -1) ) > 0) {
            numOf1 ++;
        }

        return numOf1;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(3));
    }
}
