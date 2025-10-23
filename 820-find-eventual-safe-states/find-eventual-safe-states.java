class Solution {
    static class UnWeightedGraph {
        private static class Node {
            private final int label;

            private Node(int label) {
                this.label = label;
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

        private Set<Integer> hasCycle() {
            var visited = new HashSet<Node>();
            var visiting = new TreeSet<Integer>();

            for (var node : nodesMap.values())
                hasCycle(node, visiting, visited);

            return visiting;
        }

        // Inner Details of the class
        private boolean hasCycle(Node node, Set<Integer> visiting, Set<Node> visited) {
            visiting.add(node.label);

            for (var neighbor : adjacencyList.get(node)) {
                if (visited.contains(neighbor))
                    continue;

                else if (visiting.contains(neighbor.label))
                    return true;

                if (hasCycle(neighbor, visiting, visited))
                    return true;
            }

            visited.add(node);
            visiting.remove(node.label);

            return false;
        }
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        var n = graph.length;

        var theRealGraph = new UnWeightedGraph();
        for (var i = 0; i < n; i++)
            theRealGraph.addNode(i);

        for (var i = 0; i < n; i++)
            for (var j = 0; j < graph[i].length; j++)
                theRealGraph.addEdge(i, graph[i][j]);

        var notSafeNodes = theRealGraph.hasCycle();
        var list = new ArrayList<Integer>();
        for (var i = 0; i < n; i++)
            if (!notSafeNodes.contains(i))
                list.add(i);

        return list;
    }

}