class Solution {
    private int min = Integer.MAX_VALUE;

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    colorTheGrid(i, j, grid, visited);
                    flag = true;
                    break;
                }
            }

            if (flag)
                break;
        }

        return bfs(grid);
    }

    private void colorTheGrid(int row, int col, int[][] matrix, boolean[][] visited) {

        if (row < 0 || row >= matrix.length ||
                col < 0 || col >= matrix[0].length ||
                visited[row][col] ||
                matrix[row][col] == 0)
            return;

        visited[row][col] = true;

        matrix[row][col] = 9;

        colorTheGrid(row + 1, col, matrix, visited);
        colorTheGrid(row - 1, col, matrix, visited);
        colorTheGrid(row, col + 1, matrix, visited);
        colorTheGrid(row, col - 1, matrix, visited);
    }

    private int bfs(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 9) {
                    queue.offer(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int steps = current[2];

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= n ||
                        newCol < 0 || newCol >= m ||
                        visited[newRow][newCol])
                    continue;

                if (grid[newRow][newCol] == 1)
                    return steps;

                visited[newRow][newCol] = true;

                queue.offer(new int[] {
                        newRow,
                        newCol,
                        steps + 1
                });
            }
        }

        return -1;
    }
}