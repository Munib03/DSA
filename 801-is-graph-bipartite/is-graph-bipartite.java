class Solution {
    public boolean isBipartite(int[][] graph) {
        var n = graph.length;

        List<List<Integer>> list = new ArrayList<>();
        for (var i = 0; i < n; i++)
            list.add(new ArrayList<>());

        for (var i = 0; i < n; i++) {
            var edges = graph[i];

            for (var edge : edges)
                list.get(i).add(edge);
        }

        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                var res = dfs(i, list, map, 0);

                if (!res)
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, List<List<Integer>> list, Map<Integer, Integer> map, int color) {
        map.put(node, color);

        for (var neighbor : list.get(node)) {
            if (map.containsKey(neighbor)) {
                if (map.get(neighbor) == color)
                    return false;
            } else {
                var res = dfs(neighbor, list, map, 1 - color);
                if (!res)
                    return false;
            }

        }

        return true;
    }
}