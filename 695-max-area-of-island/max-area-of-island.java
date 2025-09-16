class Solution {
    private int maxCnt = 0;
    private int tempCnt = 0;

    public int maxAreaOfIsland(int[][] grid) {
        var rows = grid.length;
        var cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                dfs(grid, i, j, visited);
                tempCnt = 0;
            }
        }

        return maxCnt;
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return;

        else if (grid[row][col] == 0 || visited[row][col])
            return;

        tempCnt++;
        maxCnt = Math.max(maxCnt, tempCnt);
        visited[row][col] = true;

        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
    }
}