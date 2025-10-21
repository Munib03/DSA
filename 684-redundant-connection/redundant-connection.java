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

        public int[] hasCycle() {
            var visiting = new LinkedHashSet<Integer>();
            var visited = new HashSet<Node>();
            int[] cycleEdge = new int[2];

            for (var node : nodesMap.values()) {
                if (hasCycle(node, visiting, visited, cycleEdge, -1))
                    return cycleEdge;
            }

            return new int[0];
        }

        private boolean hasCycle(Node node, LinkedHashSet<Integer> visiting,
                HashSet<Node> visited, int[] cycleEdge, int parent) {
            visiting.add(node.label);

            for (var neighbor : adjacencyList.get(node)) {
                if (neighbor.label == parent)
                    continue;
                if (visited.contains(neighbor))
                    continue;

                if (visiting.contains(neighbor.label)) {
                    cycleEdge[1] = node.label;
                    cycleEdge[0] = neighbor.label;
                    return true;
                }

                if (hasCycle(neighbor, visiting, visited, cycleEdge, node.label))
                    return true;
            }

            visiting.remove(node.label);
            visited.add(node);
            return false;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        var graph = new UnWeightedGraph();

        int n = edges.length;
        for (int i = 1; i <= n; i++)
            graph.addNode(i);

        for (var edge : edges) {
            graph.addEdge(edge[0], edge[1]);
            graph.addEdge(edge[1], edge[0]);

            int[] cycle = graph.hasCycle();
            if (cycle.length > 0) {
                return edge;
            }
        }

        return new int[0];
    }

}