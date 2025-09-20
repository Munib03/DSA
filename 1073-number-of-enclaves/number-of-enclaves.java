class Solution {
    public int numEnclaves(int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        for (var i = 0; i < n; i++) {
            if (grid[i][0] == 1)
                dfs(grid, i, 0);

            if (grid[i][m - 1] == 1)
                dfs(grid, i, m - 1);
        }

        for (var i = 0; i < m; i++) {
            if (grid[0][i] == 1)
                dfs(grid, 0, i);

            if (grid[n - 1][i] == 1)
                dfs(grid, n - 1, i);
        }

        var cnt = 0;
        for (var num : grid)
            for (var sth : num)
                if (sth == 1)
                    cnt++;

        return cnt;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return;

        else if (grid[row][col] == 0)
            return;

        else
            grid[row][col] = 0;

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}