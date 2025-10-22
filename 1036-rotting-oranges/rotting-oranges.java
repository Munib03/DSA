class Solution {
    public int orangesRotting(int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        var set = new HashSet<String>();
        var queue = new LinkedList<Tripe>();
        var freshOranges = 0;

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                var curr = grid[i][j];

                if (curr == 2) {
                    queue.offer(new Tripe(i, j, 0));
                    set.add(i + ", " + j);
                } else if (curr == 1)
                    freshOranges++;
            }
        }

        int[] rows = { -1, 0, 1, 0 };
        int[] cols = { 0, 1, 0, -1 };

        var maxTime = 0;
        var freshOrangesSeenSoFar = 0;

        while (!queue.isEmpty()) {
            var topOfQueue = queue.pop();

            var row = topOfQueue.row;
            var col = topOfQueue.col;
            var time = topOfQueue.time;

            maxTime = Math.max(maxTime, time);

            for (var i = 0; i < rows.length; i++) {
                var newRow = row + rows[i];
                var newCol = col + cols[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !set.contains(newRow + ", " + newCol)
                        && grid[newRow][newCol] == 1) {
                    queue.offer(new Tripe(newRow, newCol, time + 1));
                    set.add(newRow + ", " + newCol);
                    freshOrangesSeenSoFar++;
                }
            }

        }

        if (freshOranges != freshOrangesSeenSoFar)
            return -1;

        return maxTime;
    }

    private record Tripe(int row, int col, int time) {
    }
}