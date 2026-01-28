class Solution {
    public int maxProfit(int[] prices) {
        var n = prices.length;

        int[][][] dp = new int[n][2][3];
        for (var sth : dp)
            for (var againSth : sth)
                Arrays.fill(againSth, -1);

        return buyNotBuy(0, 1, 2, prices, dp);
    }

    private int buyNotBuy(int index, int canBuy, int k, int[] prices, int[][][] dp) {
        if (index >= prices.length || k == 0)
            return 0;

        else if (dp[index][canBuy][k] != -1)
            return dp[index][canBuy][k];

        else if (canBuy == 1) {
            var buy = -prices[index] + buyNotBuy(index + 1, 0, k, prices, dp);
            var notBuy = buyNotBuy(index + 1, canBuy, k, prices, dp);

            dp[index][canBuy][k] = Math.max(buy, notBuy);
        }

        else {
            var sell = prices[index] + buyNotBuy(index + 1, 1, k - 1, prices, dp);
            var notSell = buyNotBuy(index + 1, canBuy, k, prices, dp);

            dp[index][canBuy][k] = Math.max(sell, notSell);
        }

        return dp[index][canBuy][k];
    }
}