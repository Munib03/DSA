class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, n, costs, dp);
    }

    private int solve(int i, int n, int[] costs, int[] dp) {
        if (i == n)
            return 0;

        else if (i > n)
            return Integer.MAX_VALUE;

        else if (dp[i] != -1)
            return dp[i];

        var minCost = Integer.MAX_VALUE;
        for (var j = 1; j <= 3; j++) {
            if (i + j <= n) {
                var cost = costs[i + j - 1] + j * j;
                minCost = Math.min(minCost, cost + solve(i + j, n, costs, dp));
            }
        }

        dp[i] = minCost;

        return dp[i];
    }

}