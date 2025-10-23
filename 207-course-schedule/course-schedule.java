class Solution {
    private class UnWeightedGraph {
        private class Node {
            private int label;

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

        private boolean hasCycle() {
            var visited = new HashSet<Node>();
            var visiting = new HashSet<Node>();

            for (var neighbor : nodesMap.values())
                if (hasCycle(neighbor, visiting, visited))
                    return true;

            return false;
        }

        // Inner Details of the class
        private boolean hasCycle(Node node, Set<Node> visiting, Set<Node> visited) {
            visiting.add(node);

            for (var neighbor : adjacencyList.get(node)) {
                if (visited.contains(neighbor))
                    continue;

                else if (visiting.contains(neighbor))
                    return true;

                else if (hasCycle(neighbor, visiting, visited))
                    return true;
            }

            visited.remove(node);
            visited.add(node);

            return false;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var graph = new UnWeightedGraph();

        for (var i = 0; i < numCourses; i++)
            graph.addNode(i);

        for (var edge : prerequisites) {
            graph.addEdge(edge[0], edge[1]);
        }

        return !graph.hasCycle();
    }

}