class Solution {
    public int numIslands(char[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        int[] rows = { -1, 0, 1, 0 };
        int[] cols = { 0, 1, 0, -1 };

        var cnt = 0;
        var queue = new LinkedList<int[]>();

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                var curr = grid[i][j];

                if (curr == '1') {
                    grid[i][j] = '0';
                    queue.offer(new int[] { i, j });

                    while (!queue.isEmpty()) {
                        var topOfQueue = queue.pop();

                        var row = topOfQueue[0];
                        var col = topOfQueue[1];

                        for (var o = 0; o < rows.length; o++) {
                            var newRow = row + rows[o];
                            var newCol = col + cols[o];

                            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1') {
                                queue.offer(new int[] { newRow, newCol });
                                grid[newRow][newCol] = '0';
                            }
                        }
                    }

                    cnt++;
                }
            }
        }

        return cnt;
    }

}