class Solution {
    private class WeightedGraph {
        private class Node {
            private final int label;
            private final List<Edge> edges = new ArrayList<>();

            private Node(int label) {
                this.label = label;
            }

            public void addEdge(Node to, int weight) {
                this.edges.add(new Edge(to, weight));
            }

            @Override
            public String toString() {
                return label + " ";
            }
        }

        private class Edge {
            private final Node to;
            private final int weight;

            private Edge(Node to, int weight) {
                this.to = to;
                this.weight = weight;
            }

            @Override
            public String toString() {
                return to.toString();
            }
        }

        private final Map<Integer, Node> nodes = new HashMap<>();

        public void addNode(int label) {
            var newNode = new Node(label);

            nodes.putIfAbsent(label, newNode);
        }

        public void addEdge(int from, int to, int weight) {
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);

            if (fromNode == null || toNode == null)
                return;

            fromNode.addEdge(toNode, weight);
            toNode.addEdge(fromNode, weight);
        }

        private int min = Integer.MAX_VALUE;

        public int min(int startLabel) {
            var node = nodes.get(startLabel);

            dfs(node, new HashSet<>());

            return min;
        }

        // Inner Details of the class
        private void dfs(Node node, Set<Node> set) {
            if (node == null || set.contains(node))
                return;

            set.add(node);
            for (var neighbor : node.edges) {
                min = Math.min(neighbor.weight, min);

                if (!set.contains(neighbor.to))
                    dfs(neighbor.to, set);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        var graph = new WeightedGraph();

        for (var i = 1; i <= n; i++)
            graph.addNode(i);

        for (var road : roads)
            graph.addEdge(road[0], road[1], road[2]);

        return graph.min(n);
    }

}