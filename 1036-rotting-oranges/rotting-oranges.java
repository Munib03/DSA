class Solution {
    public int orangesRotting(int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        var queue = new LinkedList<Triple>();
        var freshOranges = 0;

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                var curr = grid[i][j];

                if (curr == 2)
                    queue.offer(new Triple(i, j, 0));
                else if (curr == 1)
                    freshOranges++;
            }
        }

        int[] rows = { -1, 0, 1, 0 };
        int[] cols = { 0, 1, 0, -1 };

        var maxTime = 0;
        var freshOrangesSoFar = 0;

        while (!queue.isEmpty()) {
            var topOfQueue = queue.poll();
            var row = topOfQueue.row;
            var col = topOfQueue.col;
            var time = topOfQueue.time;

            maxTime = Math.max(maxTime, time);

            for (var i = 0; i < rows.length; i++) {
                var newRow = row + rows[i];
                var newCol = col + cols[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                    queue.offer(new Triple(newRow, newCol, time + 1));
                    grid[newRow][newCol] = 0;
                    freshOrangesSoFar++;
                }
            }
        }

        if (freshOranges != freshOrangesSoFar)
            return -1;

        return maxTime;
    }

    private class Triple {
        private final int row;
        private final int col;
        private final int time;

        private Triple(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}