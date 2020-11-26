package leetcode;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/10/25
 */
public class LeetCode1024 {

    public int videoStitching(int[][] clips, int t) {
        int[] maxStep = new int[t + 1];
        int[] dp = new int[t + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i ++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int[] clip : clips) {
            int k = clip[0];
            if (k <= t) {
                maxStep[k] = Math.max(maxStep[k], clip[1] - k);
            }
        }

        for (int i = 1; i < t + 1; i ++) {
            for (int j = 0; j < i; j ++) {
                if (dp[j] != Integer.MAX_VALUE && j + maxStep[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return  dp[t] == Integer.MAX_VALUE ? - 1 : dp[t];
    }

    public static void main(String[] args) {
        int[][] clips = new int[][]{
                new int[]{0, 2},
                new int[]{4, 6},
                new int[]{8, 10},
                new int[]{1, 9},
                new int[]{1, 5},
                new int[]{5, 9}
        };

        System.out.println(new LeetCode1024().videoStitching(clips, 10));
    }
}
