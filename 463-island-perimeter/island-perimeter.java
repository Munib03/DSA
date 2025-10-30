class Solution {
    public int islandPerimeter(int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                }
            }
        }

        return cnt;
    }

    private int cnt = 0;

    private void dfs(int row, int col, int[][] grid, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
            cnt++;
            return;
        }

        else if (visited[row][col])
            return;

        visited[row][col] = true;

        dfs(row + 1, col, grid, visited);
        dfs(row - 1, col, grid, visited);
        dfs(row, col + 1, grid, visited);
        dfs(row, col - 1, grid, visited);
    }
}