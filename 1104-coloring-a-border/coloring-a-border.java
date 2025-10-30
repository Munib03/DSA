class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        var n = grid.length;
        var m = grid[0].length;

        int[][] originalArr = new int[n][m];
        for (var i = 0; i < n; i++)
            System.arraycopy(grid[i], 0, originalArr[i], 0, m);

        boolean[][] visited = new boolean[n][m];
        var initialColor = grid[row][col];
        List<int[]> comp = new ArrayList<>();

        dfs(row, col, grid, visited, initialColor, comp);

        for (var cell : comp) {
            var theRow = cell[0];
            var theCol = cell[1];

            if (theRow == 0 || theRow == n - 1 || theCol == 0 || theCol == m - 1) {
                grid[theRow][theCol] = color;
                continue;
            }

            for (var direction : new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }) {
                var newRow = theRow + direction[0];
                var newCol = theCol + direction[1];

                if (originalArr[newRow][newCol] != initialColor) {
                    grid[theRow][theCol] = color;
                    break;
                }
            }
        }

        return grid;
    }

    private void dfs(int row, int col, int[][] grid, boolean[][] visited, int initialColor, List<int[]> comp) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != initialColor
                || visited[row][col])
            return;

        visited[row][col] = true;
        comp.add(new int[] { row, col });

        dfs(row + 1, col, grid, visited, initialColor, comp);
        dfs(row - 1, col, grid, visited, initialColor, comp);
        dfs(row, col + 1, grid, visited, initialColor, comp);
        dfs(row, col - 1, grid, visited, initialColor, comp);
    }

}