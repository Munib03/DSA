class Solution {
    public int maxProfit(int[] prices) {
        var n = prices.length;

        var maxAns = 0;
        var min = prices[0];

        for (var i = 1; i < n; i++) {
            var cost = prices[i] - min;
            maxAns = Math.max(cost, maxAns);
            min = Math.min(min, prices[i]);
        }

        return maxAns;
    }

}