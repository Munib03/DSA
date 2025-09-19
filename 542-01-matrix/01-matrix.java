class Solution {
    public int[][] updateMatrix(int[][] mat) {
        var n = mat.length;
        var m = mat[0].length;

        int[][] dist = new int[n][m];
        var queue = new LinkedList<int[]>();

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[] { i, j });
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] directions = {
                { 0, 1 },
                { 1, 0 },
                { 0, -1 },
                { -1, 0 }
        };

        while (!queue.isEmpty()) {
            var frontOfQueue = queue.poll();

            var row = frontOfQueue[0];
            var col = frontOfQueue[1];

            for (var direction : directions) {
                var nr = row + direction[0];
                var nc = col + direction[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && dist[nr][nc] > dist[row][col] + 1) {
                    dist[nr][nc] = dist[row][col] + 1;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }

        return dist;
    }
}