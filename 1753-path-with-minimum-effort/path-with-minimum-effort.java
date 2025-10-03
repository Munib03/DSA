class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,0,0}); // effort, row, col

        while (!pq.isEmpty()) {
            var cur = pq.poll();
            int effort = cur[0], r = cur[1], c = cur[2];

            if (r == n-1 && c == m-1) return effort;
            if (effort > dist[r][c]) continue;

            for (var d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr<0 || nr>=n || nc<0 || nc>=m) continue;

                int nextEffort = Math.max(effort, Math.abs(heights[r][c] - heights[nr][nc]));
                if (nextEffort < dist[nr][nc]) {
                    dist[nr][nc] = nextEffort;
                    pq.offer(new int[]{nextEffort, nr, nc});
                }
            }
        }
        return 0;
    }
}
