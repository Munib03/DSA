class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return dp(n, dp);
    }

    private int dp(int n, int[] dp) {
        if (n == 0)
            return 0;

        else if (n <= 2)
            return 1;

        else if (dp[n] != -1)
            return dp[n];

        var temp = dp(n - 1, dp) + dp(n - 2, dp);
        dp[n] = temp;

        return dp[n];
    }

}