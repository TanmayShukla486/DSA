package ArrayProblems;

public class StockBuySell {
    public int maxProfitBrute(int[] ar) {
        int highestProfit = 0;
        for (int i = 0; i < ar.length - 1; i++) {
            int buyPrice = ar[i];
            for (int j = i + 1; j < ar.length; j++) {
                int profit = ar[j] - buyPrice;
                highestProfit = Math.max(profit, highestProfit);
            }
        }
        return highestProfit;
    }

    public int maxProfitOptimize1(int[] ar) {
        int currBuyPrice = ar[0], maxProfit = 0;
        for (int j = 1; j < ar.length; j++) {
            currBuyPrice = Math.min(currBuyPrice, ar[j]);
            maxProfit = Math.max(maxProfit, ar[j] - currBuyPrice);
        }
        return maxProfit;
    }
}
