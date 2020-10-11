package fastslow;

import java.util.Arrays;

/**
 * 去除数组中的重复元素
 * @author 郑凯努
 * @version 1.0
 * @date 2020/7/26
 */
public class ArrayRemoveDuplicate {

    public static int[] removeDuplicate(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int slow = 0, fast = 1;
        while (fast < array.length) {
            if (array[slow] != array[fast]) {
                slow ++;
                array[slow] = array[fast];
            }
            fast ++;
        }

        return Arrays.copyOfRange(array, 0, slow);
    }

    public static void main(String[] args) {
        int[] a = removeDuplicate(new int[] {1,2,3,3,4,6,7,7,8});
        for (int i : a) {
            System.out.println(i);
        }
    }
}
