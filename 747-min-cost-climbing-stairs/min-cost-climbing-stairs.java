class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var n = cost.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        var ans1 = ans(0, cost, dp);
        var ans2 = ans(1, cost, dp);

        return Math.min(ans1, ans2);
    }

    private int ans(int index, int[] costs, int[] dp) {
        if (index >= costs.length)
            return 0;

        else if (dp[index] != -1)
            return dp[index];

        var oneStep = costs[index] + ans(index + 1, costs, dp);
        var twoStep = costs[index] + ans(index + 2, costs, dp);

        var min = Math.min(oneStep, twoStep);
        return dp[index] = min;
    }

}