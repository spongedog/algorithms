package leetcode;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/11/16
 */
public class LeetCode4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] allNums = new int[length];
        int k = 0;
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                allNums[k++] = nums1[i++];
            } else {
                allNums[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            allNums[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            allNums[k++] = nums2[j++];
        }

        if (length % 2 == 0) {
            return (allNums[length / 2 - 1] + allNums[length/2]) / 2.0;
        } else {
            return allNums[length/2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2};
        int[] nums2 = new int[] {3,4};

        System.out.println(LeetCode4.findMedianSortedArrays(nums1, nums2));
    }
}
