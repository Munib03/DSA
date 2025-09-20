class Solution {

    public int numIslands(char[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        boolean[][] visitedNodes = new boolean[n][m];
        var cnt = 0;

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visitedNodes[i][j]) {
                    dfs(grid, i, j, visitedNodes);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visitedNodes) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visitedNodes[row][col]
                || grid[row][col] == '0')
            return;

        visitedNodes[row][col] = true;
        dfs(grid, row + 1, col, visitedNodes);
        dfs(grid, row - 1, col, visitedNodes);
        dfs(grid, row, col + 1, visitedNodes);
        dfs(grid, row, col - 1, visitedNodes);
    }
}