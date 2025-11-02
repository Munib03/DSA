class Solution {
    private static class UnWeightedGraph<T> {
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
        }

        public int numberOfConnectedComponents() {
            var cnt = 0;
            var set = new HashSet<Node>();

            for (var node : nodesMap.values()) {
                if (!set.contains(node)) {
                    numberOfConnectedComponents(node, set);
                    cnt++;
                }
            }

            return cnt;
        }

        // Inner Details of the class
        private void numberOfConnectedComponents(Node node, Set<Node> set) {
            if (node == null || set.contains(node))
                return;

            set.add(node);

            for (var neighbor : adjacencyList.get(node))
                if (!set.contains(neighbor))
                    numberOfConnectedComponents(neighbor, set);

        }
    }

    public int findCircleNum(int[][] isConnected) {
        var n = isConnected.length;

        var graph = new UnWeightedGraph<Integer>();
        for (var i = 1; i <= n; i++)
            graph.addNode(i);

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    graph.addEdge(i + 1, j + 1);
                }
            }
        }

        return graph.numberOfConnectedComponents();
    }

}