class Solution {
public int minPathSum(int[][] grid) {
  var n = grid.length;
  var m = grid[0].length;

  int[][] dp = new int[n][m];
  for (var sth: dp)
    Arrays.fill(sth, -1);

  return dfs(0, 0, grid, dp);
}

private int dfs(int i, int j, int[][] grid, int[][] dp) {
  if (i >= grid.length || j >= grid[0].length)
    return Integer.MAX_VALUE;

  else if (i == grid.length - 1 && j == grid[i].length - 1)
    return grid[i][j];

  else if (dp[i][j] != -1)
    return dp[i][j];

  var down = dfs(i + 1, j, grid, dp);
  var right = dfs(i, j + 1, grid, dp);

  var min = grid[i][j] + Math.min(down, right);
  dp[i][j] = min;

  return dp[i][j];
}

}