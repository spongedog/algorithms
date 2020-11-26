package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/11/25
 */
public class Leetcode15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[right - 1]) {
                        right --;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right --;
                    left++;
                } else if (sum > 0) {
                    right --;
                } else {
                    left ++;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Leetcode15.threeSum(new int[] {-2,-2,-2,-2,0,0,0,2,2,2}));
    }
}
