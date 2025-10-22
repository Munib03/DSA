class Solution {
    private static class UnWeightedGraph {
        private record Node(int label) {
        }

        private final Map<Integer, Node> nodesMap = new HashMap<>();
        private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

        public void addNode(int val) {
            var newNode = new Node(val);

            nodesMap.putIfAbsent(val, newNode);
            adjacencyList.putIfAbsent(newNode, new ArrayList<>());
        }

        public void addEdge(int from, int to) {
            var fromNode = nodesMap.get(from);
            var toNode = nodesMap.get(to);

            if (fromNode == null || toNode == null)
                return;

            adjacencyList.get(fromNode).add(toNode);
        }

        private boolean isBipartiteGraph() {
            var map = new HashMap<Node, Integer>();

            for (var node : nodesMap.values()) {
                if (!map.containsKey(node))
                    if (!dfs(node, map, 0))
                        return false;
            }

            return true;
        }

        // Inner Details of the class
        private boolean dfs(Node node, Map<Node, Integer> map, int color) {
            map.putIfAbsent(node, color);

            for (var neighbor : adjacencyList.get(node)) {
                if (map.containsKey(neighbor)) {
                    if (map.get(neighbor) == color)
                        return false;
                } else {
                    var res = dfs(neighbor, map, 1 - color);
                    if (!res)
                        return false;
                }
            }

            return true;
        }
    }

    public boolean isBipartite(int[][] graph) {
        var n = graph.length;

        var theGraph = new UnWeightedGraph();
        for (var i = 0; i < n; i++)
            theGraph.addNode(i);

        for (var i = 0; i < n; i++)
            for (var j = 0; j < graph[i].length; j++)
                theGraph.addEdge(i, graph[i][j]);

        return theGraph.isBipartiteGraph();
    }

}