class Solution {
    private static class UnWeightedGraph {
        private static class Node {
            private final int label;

            private Node(int label) {
                this.label = label;
            }

            @Override
            public String toString() {
                return label + "";
            }
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

        public int findNumberOfCities() {
            var set = new HashSet<Node>();
            var cnt = 0;

            for (var node : nodesMap.values()) {
                if (!set.contains(node)) {
                    dfs(node, set);
                    cnt++;
                }
            }

            return cnt;
        }

        // Inner Details of the class
        private void dfs(Node root, Set<Node> set) {
            if (root == null || set.contains(root))
                return;

            set.add(root);
            for (var neighbor : adjacencyList.get(root))
                if (!set.contains(neighbor))
                    dfs(neighbor, set);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        var n = isConnected.length;

        var graph = new UnWeightedGraph();
        for (var i = 1; i <= n; i++)
            graph.addNode(i);

        for (var i = 0; i < n; i++)
            for (var j = 0; j < isConnected[i].length; j++)
                if (isConnected[i][j] == 1)
                    graph.addEdge(i + 1, j + 1);

        return graph.findNumberOfCities();
    }

}