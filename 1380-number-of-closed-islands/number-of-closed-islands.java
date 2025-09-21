class Solution {
    public int closedIsland(int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        for (var i = 0; i < n; i++)
            if (grid[i][0] == 0)
                dfs(grid, i, 0);

        for (var i = 0; i < n; i++)
            if (grid[i][m - 1] == 0)
                dfs(grid, i, m - 1);

        for (var i = 0; i < m; i++)
            if (grid[0][i] == 0)
                dfs(grid, 0, i);

        for (var i = 0; i < m; i++)
            if (grid[n - 1][i] == 0)
                dfs(grid, n - 1, i);

        var cnt = 0;
        boolean[][] visited = new boolean[n][m];

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 0)
            return;

        visited[row][col] = true;

        if (grid[row][col] == 0)
            grid[row][col] = 3;

        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
    }

    private void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 0)
            return;

        grid[row][col] = 2;

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}