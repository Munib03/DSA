class Solution {
    public int numIslands(char[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        boolean[][] visitedNodes = new boolean[n][m];
        var cnt = 0;

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visitedNodes[i][j]) {
                    bfs(grid, i, j, visitedNodes);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void bfs(char[][] grid, int row, int col, boolean[][] visited) {
        var n = grid.length;
        var m = grid[0].length;

        int[][] directions = {
                { 1, 0 },
                { 0, 1 },
                { -1, 0 },
                { 0, -1 }
        };

        visited[row][col] = true;

        var queue = new LinkedList<int[]>();
        queue.offer(new int[] { row, col });

        while (!queue.isEmpty()) {
            var frontOfQueue = queue.poll();

            var r = frontOfQueue[0];
            var c = frontOfQueue[1];

            for (var direction : directions) {
                var nr = r + direction[0];
                var nc = c + direction[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1' && !visited[nr][nc]) {
                    queue.offer(new int[] { nr, nc });
                    visited[nr][nc] = true;
                }
            }
        }
    }

}