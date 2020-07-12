package dynamic;

import java.util.*;

/**
 * 最小硬币数
 * @author 郑凯努 date 2020/7/12
 */
public class MinCoinDemo {

    public static int coinChange(List<Integer> coins, int targetAmount) {
        int[] dp = new int[targetAmount + 1];
        Arrays.fill(dp, targetAmount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i ++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[targetAmount] != targetAmount + 1 ? dp[targetAmount] : -1;
    }

    public static int coinChangeRecursion(List<Integer> coins, int targetAmount) {
        Map<Integer, Integer> coinAmountMap = new HashMap<>(16);
        return dp(coins, targetAmount, coinAmountMap);
    }

    private static int dp(List<Integer> coins, int targetAmount, Map<Integer,Integer> coinAmountMap) {
        if (coinAmountMap.containsKey(targetAmount)) {
            return coinAmountMap.get(targetAmount);
        }

        if (targetAmount == 0) {
            return 0;
        }

        if (targetAmount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            int amount = dp(coins, targetAmount - coin, coinAmountMap);
            if (amount < 0) {
                continue;
            }
            res = Math.min(res, amount + 1);
        }

        coinAmountMap.put(targetAmount, res != Integer.MAX_VALUE ? res : -1);

        return coinAmountMap.get(targetAmount);
    }

    public static void main(String[] args) {
        int type = new Scanner(System.in).nextInt();
        int targetAmount = 99;
        List<Integer> coins = Arrays.asList(1, 2, 5);

        if (type == 0) {
            System.out.println(MinCoinDemo.coinChange(coins, targetAmount));
        } else {
            System.out.println(MinCoinDemo.coinChangeRecursion(coins, targetAmount));
        }
    }
}
