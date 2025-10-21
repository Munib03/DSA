class Solution {
    public int numIslands(char[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        var cnt = 0;

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]
                || grid[row][col] == '0')
            return;

        visited[row][col] = true;

        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
    }

}