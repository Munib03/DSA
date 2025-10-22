class Solution {
    public int numEnclaves(int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        var queue = new LinkedList<int[]>();

        for (var i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                queue.offer(new int[] { 0, i });
                grid[0][i] = 0;
            }

            if (grid[n - 1][i] == 1) {
                queue.offer(new int[] { n - 1, i });
                grid[n - 1][i] = 0;
            }
        }

        for (var i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                queue.offer(new int[] { i, 0 });
                grid[i][0] = 0;
            }

            if (grid[i][m - 1] == 1) {
                queue.offer(new int[] { i, m - 1 });
                grid[i][m - 1] = 0;
            }
        }

        int[] rows = { -1, 0, 1, 0 };
        int[] cols = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            var topOfQueue = queue.poll();

            var row = topOfQueue[0];
            var col = topOfQueue[1];

            for (var i = 0; i < rows.length; i++) {
                var newRow = row + rows[i];
                var newCol = col + cols[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                    queue.offer(new int[] { newRow, newCol });
                    grid[newRow][newCol] = 0;
                }
            }
        }

        var cnt = 0;
        for (var i = 0; i < n; i++)
            for (var j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    cnt++;

        return cnt;
    }

}