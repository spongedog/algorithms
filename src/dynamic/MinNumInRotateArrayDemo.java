package dynamic;

/**
 * 旋转数组的最小值
 * @author 郑凯努
 * @version 1.0
 * @date 2020/7/22
 */
public class MinNumInRotateArrayDemo {

    public static int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }

        int first = 0, last = array.length - 1;

        while(first < last) {
            int mid = first + (last - first)/2;
            if (array[mid] > array[first]) {
                first = mid + 1;
            } else if (array[mid] < array[first]) {
                last = mid;
            } else {
                last --;
            }
        }

        return array[first];
    }

    public static void main(String[] args) {
        System.out.println(MinNumInRotateArrayDemo.minNumberInRotateArray(new int[]{3,4,5,1,2}));
    }
}
