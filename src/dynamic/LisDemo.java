package dynamic;

import java.util.Arrays;
import java.util.List;

/**
 * 最长递增子序列长度
 * @author 郑凯努
 * @version 1.0
 * @date 2020/7/12
 */
public class LisDemo {

    public static int maxLength(List<Integer> nums) {
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.size(); i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums.get(i) > nums.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().orElse(0);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 5, 3, 4, 6, 9);
        System.out.println(maxLength(nums));
    }
}
