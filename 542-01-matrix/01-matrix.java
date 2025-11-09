class Solution {
    public int[][] updateMatrix(int[][] mat) {
        var n = mat.length;
        var m = mat[0].length;

        var set = new HashSet<String>();
        var queue = new LinkedList<Tripe>();
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new Tripe(i, j, 0));
                    mat[i][j] = 0;
                    set.add(i + ", " + j);
                }
            }
        }

        int[] rows = { -1, 0, 1, 0 };
        int[] cols = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            var topOfQueue = queue.poll();
            var row = topOfQueue.row;
            var col = topOfQueue.col;
            var numOfSteps = topOfQueue.numOfSteps;

            for (var i = 0; i < rows.length; i++) {
                var newRow = row + rows[i];
                var newCol = col + cols[i];

                var key = newRow + ", " + newCol;
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !set.contains(key)) {
                    queue.offer(new Tripe(newRow, newCol, numOfSteps + 1));
                    set.add(key);
                    mat[newRow][newCol] = numOfSteps + 1;
                }
            }
        }

        return mat;
    }

    private record Tripe(int row, int col, int numOfSteps) {

    }

}