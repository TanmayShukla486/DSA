package DynamicProgramming;

import java.util.Arrays;

public class CountMinCoins {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 1 && amount % coins[0] != 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, (int) 1e9);
        int n = coins.length;
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] == (1e9) ? -1 : dp[amount];
    }
}
