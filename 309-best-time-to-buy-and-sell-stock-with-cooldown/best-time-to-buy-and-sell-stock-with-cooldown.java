class Solution {
    public int maxProfit(int[] prices) {
        var n = prices.length;

        int[][] dp = new int[n][2];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        return buyNotBuy(0, 1, prices, dp);
    }

    private int buyNotBuy(int day, int canBuy, int[] prices, int[][] dp) {
        if (day >= prices.length)
            return 0;

        else if (dp[day][canBuy] != -1)
            return dp[day][canBuy];

        var profit = 0;
        if (canBuy == 1) {
            var buy = -prices[day] + buyNotBuy(day + 1, 0, prices, dp);
            var skip = buyNotBuy(day + 1, 1, prices, dp);

            profit = Math.max(buy, skip);
        } else {
            var sell = prices[day] + buyNotBuy(day + 2, 1, prices, dp);
            var skip = buyNotBuy(day + 1, 0, prices, dp);

            profit = Math.max(sell, skip);
        }

        dp[day][canBuy] = profit;

        return profit;
    }
}