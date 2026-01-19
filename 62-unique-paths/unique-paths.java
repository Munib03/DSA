class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        return dfs(0, 0, m, n, dp);
    }

    private int dfs(int i, int j, int m, int n, int[][] dp) {
        if (i > m || j > n)
            return 0;

        else if (i == m - 1 && j == n - 1)
            return 1;

        else if (dp[i][j] != -1)
            return dp[i][j];

        var up = dfs(i + 1, j, m, n, dp);
        var right = dfs(i, j + 1, m, n, dp);

        var sum = up + right;
        dp[i][j] = sum;

        return dp[i][j];
    }

}