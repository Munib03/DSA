class Solution {
    public int minFallingPathSum(int[][] matrix) {
        var n = matrix.length;
        var m = matrix[0].length;

        int[][] dp = new int[n][m];
        for (var sth : dp)
            Arrays.fill(sth, -200);

        var minAns = Integer.MAX_VALUE;

        for (var i = 0; i < m; i++) {
            var currMin = dfs(0, i, matrix, dp);
            minAns = Math.min(minAns, currMin);
        }

        return minAns;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= dp[i].length)
            return Integer.MAX_VALUE;

        else if (i == matrix.length - 1)
            return matrix[i][j];

        else if (dp[i][j] != -200)
            return dp[i][j];

        var down = dfs(i + 1, j, matrix, dp);
        var leftDig = dfs(i + 1, j - 1, matrix, dp);
        var rightDig = dfs(i + 1, j + 1, matrix, dp);

        var min = matrix[i][j] + Math.min(down, Math.min(leftDig, rightDig));
        dp[i][j] = min;

        return min;
    }

}