class Solution {
    public int dij(int V, int[][] grid, int destination) {
        int n = grid.length;
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();

        for (int i = 0; i < n * n; i++)
            graph.add(new ArrayList<>());

        int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1)
                    continue;
                int from = r * n + c;
                for (int k = 0; k < 8; k++) {
                    int nr = r + dr[k], nc = c + dc[k];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                        int to = nr * n + nc;
                        graph.get(from).add(new Pair<>(to, 1));
                    }
                }
            }
        }

        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < n * n; i++)
            map.put(i, Integer.MAX_VALUE);
        map.replace(0, 0);

        var set = new HashSet<Integer>();
        var pq = new PriorityQueue<Pair<Integer, Integer>>(
                Comparator.comparingInt(ne -> ne.weight));
        pq.offer(new Pair<>(0, 0));

        while (!pq.isEmpty()) {
            var frontOfQueue = pq.poll().node;
            set.add(frontOfQueue);

            for (var edge : graph.get(frontOfQueue)) {
                if (set.contains(edge.node))
                    continue;

                var newDestination = map.get(frontOfQueue) + edge.weight;
                if (newDestination < map.get(edge.node)) {
                    map.put(edge.node, newDestination);
                    pq.offer(new Pair<>(edge.node, newDestination));
                }
            }
        }

        if (map.get(destination).equals(Integer.MAX_VALUE))
            return -1;

        return map.get(destination) + 1; 
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 1 && grid[0][0] == 1)
            return -1;


        return dij(n * n, grid, n * n - 1);
    }

    private record Pair<Node, Weight>(Node node, Weight weight) {
    }
}
