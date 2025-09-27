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

        public void addNode(int node) {
            var newNode = new Node(node);

            nodes.putIfAbsent(node, newNode);
            adjacencyList.putIfAbsent(newNode, new ArrayList<>());
        }

        public void addEdge(int from, int to) {
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);

            if (fromNode == null || toNode == null)
                return;

            adjacencyList.get(fromNode).add(toNode);
        }

        public List<Integer> findEventualStates() {
            var visiting = new HashSet<Node>();
            var visited = new HashSet<Node>();

            for (var node : nodes.values())
                hasCycle(node, visiting, visited);

            var list = new ArrayList<Integer>();
            for (var node : nodes.values())
                if (!visiting.contains(node))
                    list.add(node.label);

            return list;
        }

        // Inner Details of the class
        private boolean hasCycle(Node node, Set<Node> visiting, Set<Node> visited) {
            visiting.add(node);

            for (var neighbor : adjacencyList.get(node)) {
                if (visited.contains(neighbor))
                    continue;

                else if (visiting.contains(neighbor)) {
                    return true;
                }

                if (hasCycle(neighbor, visiting, visited))
                    return true;
            }

            visiting.remove(node);
            visited.add(node);

            return false;
        }

    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        var theGraph = new Graph();

        for (var i = 0; i < graph.length; i++)
            theGraph.addNode(i);

        for (var i = 0; i < graph.length; i++)
            for (var j = 0; j < graph[i].length; j++)
                theGraph.addEdge(i, graph[i][j]);

        return theGraph.findEventualStates();
    }
}