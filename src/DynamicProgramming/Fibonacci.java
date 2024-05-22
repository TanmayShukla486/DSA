package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {



    public int getFibonacci(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = getFibonacci(n - 1, dp) + getFibonacci(n - 2, dp);
    }

    public static void main(String[] args) {
        int[] dp = new int[5];
        Arrays.fill(dp, -1);
        dp[0] = 0; dp[1] = 1;
        new Fibonacci().getFibonacci(4, dp);
    }
}
