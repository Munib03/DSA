class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;

        List<List<Integer>> graph = new ArrayList<>();

        for (var i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (var edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        var queue = new ArrayDeque<Integer>();

        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            var frontOfQueue = queue.poll();

            if (frontOfQueue == destination)
                return true;

            for (var neighbor : graph.get(frontOfQueue))
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
        }

        return false;
    }
}