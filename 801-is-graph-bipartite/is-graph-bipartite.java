class Solution {
    private class UnWeightedGraph<T> {
        private class Node {
            private final T label;

            private Node(T label) {
                this.label = label;
            }

            @Override
            public String toString() {
                return label.toString();
            }
        }

        private final Map<T, Node> nodesMap = new HashMap<>();
        private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

        public void addNode(T val) {
            var newNode = new Node(val);

            nodesMap.putIfAbsent(val, newNode);
            adjacencyList.putIfAbsent(newNode, new ArrayList<>());
        }

        public void addEdge(T from, T to) {
            var fromNode = nodesMap.get(from);
            var toNode = nodesMap.get(to);

            if (fromNode == null || toNode == null)
                return;

            adjacencyList.get(fromNode).add(toNode);
            adjacencyList.get(toNode).add(fromNode);
        }

        public boolean isGraphBip() {

            for (var node : nodesMap.values()) {
                var ans = isGraphBip(node, new HashMap<>(), 0);
                if (!ans)
                    return false;
            }

            return true;
        }

        // Inner Details of the class
        private boolean isGraphBip(Node node, Map<Node, Integer> colorMap, int color) {
            if (node == null)
                return true;

            for (var neighbor : adjacencyList.get(node)) {
                if (colorMap.containsKey(neighbor)) {
                    if (colorMap.get(neighbor).equals(color))
                        return false;
                } else {
                    colorMap.put(neighbor, 1 - color);
                    if (!(isGraphBip(neighbor, colorMap, 1 - color)))
                        return false;
                }
            }

            return true;
        }
    }

    public boolean isBipartite(int[][] graph) {
        var n = graph.length;

        var theRealGraph = new UnWeightedGraph<Integer>();
        for (var i = 0; i < n; i++)
            theRealGraph.addNode(i);

        for (var i = 0; i < n; i++)
            for (var j = 0; j < graph[i].length; j++)
                theRealGraph.addEdge(i, graph[i][j]);

        return theRealGraph.isGraphBip();
    }

}