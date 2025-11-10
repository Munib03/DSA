class Solution {
    private class UnWeightedUnDirectedGraph {
        private class Node {
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

        public Set<Integer> hasCycle() {
            var visited = new HashSet<Node>();
            var visiting = new HashSet<Integer>();

            for (var node : nodesMap.values()) {
                hasCycle(node, visited, visiting);
            }

            return visiting;
        }

        // Inner Details of the class
        private boolean hasCycle(Node node, Set<Node> visited, Set<Integer> visiting) {
            visiting.add(node.label);

            for (var neighbor : adjacencyList.get(node)) {
                if (visited.contains(neighbor))
                    continue;

                if (visiting.contains(neighbor.label))
                    return true;

                else if (hasCycle(neighbor, visited, visiting))
                    return true;
            }

            visiting.remove(node.label);
            visited.add(node);

            return false;
        }
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        var n = graph.length;

        var theGraph = new UnWeightedUnDirectedGraph();

        for (var i = 0; i < n; i++)
            theGraph.addNode(i);

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < graph[i].length; j++) {
                theGraph.addEdge(i, graph[i][j]);
            }
        }

        var list = new ArrayList<Integer>();
        var notSafeNodes = theGraph.hasCycle();

        for (var i = 0; i < n; i++)
            if (!notSafeNodes.contains(i))
                list.add(i);

        return list;
    }

}