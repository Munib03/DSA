class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;

        else if (n == 1 && grid[0][0] == 0)
            return 1;

        var set = new HashSet<String>();
        var queue = new LinkedList<Pair>();

        int[][] destination = new int[n][m];
        for (var dist : destination)
            Arrays.fill(dist, Integer.MAX_VALUE);

        set.add(0 + ", " + 0);
        queue.offer(new Pair(0, 0, 0));
        destination[0][0] = 0;

        int[] rows = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] cols = { -1, 0, 1, -1, 1, -1, 0, 1 };

        while (!queue.isEmpty()) {
            var topOfQueue = queue.poll();

            var row = topOfQueue.row;
            var col = topOfQueue.col;

            for (var i = 0; i < rows.length; i++) {
                var newRow = row + rows[i];
                var newCol = col + cols[i];
                var currNumOfSteps = 1 + topOfQueue.numberOfSteps;

                var key = newRow + ", " + newCol;
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !set.contains(key) &&
                        grid[newRow][newCol] == 0 && currNumOfSteps < destination[newRow][newCol]) {
                    if (newRow == n - 1 && newCol == m - 1)
                        return currNumOfSteps + 1;

                    queue.offer(new Pair(newRow, newCol, currNumOfSteps));
                    set.add(key);
                }
            }
        }

        return -1;
    }

    private record Pair(int row, int col, int numberOfSteps) {

    }
}