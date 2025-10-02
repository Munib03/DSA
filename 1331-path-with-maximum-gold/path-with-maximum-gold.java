class Solution {
    private int min = Integer.MIN_VALUE;

    public int getMaximumGold(int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for (var i = 0; i < n; i++)
            for (var j = 0; j < m; j++)
                if (grid[i][j] != 0)
                    dfs(0, grid, visited, i, j);

        if (min == Integer.MIN_VALUE)
            min = 0;

        return min;
    }

    private void dfs(int currSum, int[][] matrix, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == 0
                || visited[row][col])
            return;

        currSum += matrix[row][col];
        min = Math.max(currSum, min);
        visited[row][col] = true;

        dfs(currSum, matrix, visited, row + 1, col);
        dfs(currSum, matrix, visited, row - 1, col);
        dfs(currSum, matrix, visited, row, col + 1);
        dfs(currSum, matrix, visited, row, col - 1);

        visited[row][col] = false;
    }
}
