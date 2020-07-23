package dynamic;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/7/23
 */
public class JumpFloorDemo {

    public static int JumpFloorII(int target) {
        int[] dp = new int[target + 1];
        dp[1] = 1;

        if (target <= 1) {
            return dp[target];
        }

        for (int i = 2; i < target + 1; i ++){
            for (int j = 1; j < i; j ++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(2));
    }
}
