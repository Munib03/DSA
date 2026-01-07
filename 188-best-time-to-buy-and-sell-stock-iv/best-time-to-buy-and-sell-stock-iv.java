class Solution {
    public int maxProfit(int k, int[] prices) {
        var n = prices.length;

        int[][][] dp = new int[n][2][k + 1];
        for (var sth : dp)
            for (var againSth : sth)
                Arrays.fill(againSth, -1);

        return buyNotBuy(0, 1, k, prices, dp);
    }

    private int buyNotBuy(int day, int canBuy, int transactionLeft, int[] prices, int[][][] dp) {
        if (day == prices.length || transactionLeft == 0)
            return 0;

        else if (dp[day][canBuy][transactionLeft] != -1)
            return dp[day][canBuy][transactionLeft];

        var profit = 0;
        if (canBuy == 1) {
            var buy = -prices[day] + buyNotBuy(day + 1, 0, transactionLeft, prices, dp);
            var skip = buyNotBuy(day + 1, 1, transactionLeft, prices, dp);

            profit = Math.max(buy, skip);
        }

        else {
            var sell = prices[day] + buyNotBuy(day + 1, 1, transactionLeft - 1, prices, dp);
            var skip = buyNotBuy(day + 1, 0, transactionLeft, prices, dp);

            profit = Math.max(sell, skip);
        }

        dp[day][canBuy][transactionLeft] = profit;

        return profit;
    }
}