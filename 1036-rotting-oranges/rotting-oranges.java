class Solution {
    public int orangesRotting(int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        var queue = new LinkedList<Triple>();
        var set = new HashSet<String>();
        var freshOranges = 0;

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Triple(i, j, 0));
                    set.add(i + ", " + j);
                } else if (grid[i][j] == 1)
                    freshOranges++;
            }
        }

        var maxTime = 0;

        var cnt = 0;
        int[] rows = { -1, 0, 1, 0 };
        int[] cols = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            var topOfQueue = queue.pop();

            var row = topOfQueue.row;
            var col = topOfQueue.col;
            var time = topOfQueue.time;

            maxTime = Math.max(maxTime, time);

            for (var i = 0; i < 4; i++) {
                var newRow = row + rows[i];
                var newCol = col + cols[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !set.contains(newRow + ", " + newCol)
                        && grid[newRow][newCol] == 1) {
                    queue.offer(new Triple(newRow, newCol, time + 1));
                    set.add(newRow + ", " + newCol);
                    cnt++;
                }
            }
        }

        if (freshOranges != cnt)
            return -1;

        return maxTime;
    }

    private static class Triple {
        private int row;
        private int col;
        private int time;

        private Triple(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

}