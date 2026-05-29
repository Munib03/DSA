class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        var graph = theGraph(n, dislikes);

        for (var node : graph.keySet()) {
            var ans = colorTheGraph(node, graph, new HashMap<>(), 0);
            if (!ans)
                return false;
        }

        return true;
    }

    public Map<Integer, List<Integer>> theGraph(int n, int[][] dislikes) {
        var map = new HashMap<Integer, List<Integer>>();

        for (var i = 1; i <= n; i++)
            map.computeIfAbsent(i, k -> new ArrayList<>());

        for (var dislike : dislikes) {
            map.get(dislike[0]).add(dislike[1]);
        }

        return map;
    }

    private boolean colorTheGraph(int node,
            Map<Integer, List<Integer>> graph,
            Map<Integer, Integer> colorMap,
            int color) {
        for (var neighbor : graph.get(node)) {
            if (colorMap.containsKey(neighbor)) {
                if (colorMap.get(neighbor).equals(color))
                    return false;
            } else {
                colorMap.put(neighbor, 1 - color);
                colorTheGraph(neighbor, graph, colorMap, 1 - color);
            }
        }

        return true;
    }

}