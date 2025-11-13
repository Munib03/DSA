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
        }

        private boolean hasCycle() {
            var visited = new HashSet<Node>();
            var visiting = new HashSet<Node>();

            for (var node : nodesMap.values()) {
                if (hasCycle(node, visiting, visited))
                    return true;
            }

            return false;
        }

        // Inner Details of the class
        private boolean hasCycle(Node node, Set<Node> visiting, Set<Node> visited) {
            visiting.add(node);

            for (var neighbor : adjacencyList.get(node)) {
                if (visited.contains(neighbor))
                    continue;

                if (visiting.contains(neighbor) || hasCycle(neighbor, visiting, visited))
                    return true;
            }

            visiting.remove(node);
            visited.add(node);

            return false;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var graph = new UnWeightedGraph<Integer>();
        for (var i = 0; i < numCourses; i++)
            graph.addNode(i);

        for (var prerequisite : prerequisites)
            graph.addEdge(prerequisite[1], prerequisite[0]);

        return !graph.hasCycle();
    }

}