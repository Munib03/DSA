class Solution {
    public int maxProfit(int[] prices, int fee) {
        var n = prices.length;

        int[][] dp = new int[n][2];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        return buyNotBuy(0, 1, fee, prices, dp);
    }

    private int buyNotBuy(int index, int canBuy, int fee, int[] prices, int[][] dp) {
        if (index == prices.length)
            return 0;

        else if (dp[index][canBuy] != -1)
            return dp[index][canBuy];

        else if (canBuy == 1) {
            var buy = -prices[index] + buyNotBuy(index + 1, 0, fee, prices, dp);
            var notBuy = buyNotBuy(index + 1, canBuy, fee, prices, dp);

            dp[index][canBuy] = Math.max(buy, notBuy);
        }

        else {
            var sell = prices[index] - fee + buyNotBuy(index + 1, 1, fee, prices, dp);
            var notSell = buyNotBuy(index + 1, canBuy, fee, prices, dp);

            dp[index][canBuy] = Math.max(sell, notSell);
        }

        return dp[index][canBuy];
    }
}