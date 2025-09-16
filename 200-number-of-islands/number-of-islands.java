class Solution {
    public int numIslands(char[][] grid) {
        var rows = grid.length;
        var cols = grid[0].length;

        if (rows == 0)
            return 0;

        boolean[][] visitedNodes = new boolean[rows][cols];
        var cnt = 0;

        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {

                if (grid[i][j] == '1' && !visitedNodes[i][j]) {
                    dfs(grid, i, j, visitedNodes);
                    cnt++;
                }

            }
        }

        return cnt;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return;

        if (visited[row][col] || grid[row][col] == '0')
            return;

        visited[row][col] = true;

        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
    }
}