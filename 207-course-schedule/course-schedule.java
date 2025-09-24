class Solution {
    private class Graph {
        private class Node {
            private int label;

            private Node(int label) {
                this.label = label;
            }

            @Override
            public String toString() {
                return label + "";
            }
        }

        private final Map<Integer, Node> nodes = new HashMap<>();
        private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

        public void addNode(int label) {
            var newNode = new Node(label);

            nodes.putIfAbsent(label, newNode);
            adjacencyList.put(newNode, new ArrayList<>());
        }

        public void addEdge(int from, int to) {
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);

            if (fromNode == null || toNode == null)
                return;

            adjacencyList.get(fromNode).add(toNode);
        }

        public boolean hasCycle() {
            var visiting = new HashSet<Node>();
            var visited = new HashSet<Node>();

            for (var node : nodes.values()) {
                if (hasCycle(node, visiting, visited))
                    return true;
            }

            return false;
        }

        // Inner Details
        private boolean hasCycle(Node node, Set<Node> visiting, Set<Node> visited) {
            visiting.add(node);

            for (var neighbor : adjacencyList.get(node)) {
                if (visited.contains(neighbor))
                    continue;

                else if (visiting.contains(neighbor))
                    return true;

                if (hasCycle(neighbor, visiting, visited))
                    return true;
            }

            visiting.remove(node);
            visited.add(node);

            return false;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var graph = new Graph();

        for (var i = 0; i < numCourses; i++)
            graph.addNode(i);

        for (var edge : prerequisites)
            graph.addEdge(edge[0], edge[1]);

        return !graph.hasCycle();
    }

}