class Solution {
    private int max = 0;

    public int findMaxFish(int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    tempSum = 0;
                }
            }
        }

        return max;
    }

    private int tempSum = 0;

    private void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || visited[row][col]
                || grid[row][col] == 0)
            return;

        tempSum += grid[row][col];
        max = Math.max(max, tempSum);
        visited[row][col] = true;

        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
    }
}