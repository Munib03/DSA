class Solution {
    public int numEnclaves(int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        for (var i = 0; i < m; i++) {
            if (grid[0][i] == 1)
                dfs(0, i, grid);

            if (grid[n - 1][i] == 1)
                dfs(n - 1, i, grid);
        }

        for (var i = 0; i < n; i++) {
            if (grid[i][0] == 1)
                dfs(i, 0, grid);

            if (grid[i][m - 1] == 1)
                dfs(i, m - 1, grid);
        }

        var cnt = 0;

        for (var i = 0; i < n; i++)
            for (var j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    cnt++;

        return cnt;
    }

    private void dfs(int row, int col, int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] != 1)
            return;

        grid[row][col] = 0;

        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
}