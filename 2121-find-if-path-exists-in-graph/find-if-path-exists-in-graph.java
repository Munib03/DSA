class Solution {
    class Graph {
        private class Node {
            private String label;

            private Node(String label) {
                this.label = label;
            }

            @Override
            public String toString() {
                return label;
            }
        }

        private Map<String, Node> nodes = new HashMap<>();
        private Map<Node, List<Node>> adjacencyList = new HashMap<>();

        public void addNode(String label) {
            var node = new Node(label);

            nodes.putIfAbsent(label, node);
            adjacencyList.putIfAbsent(node, new ArrayList<>());
        }

        public void addEdge(String from, String to) {
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);

            if (fromNode == null || toNode == null)
                return;

            adjacencyList.get(fromNode).add(toNode);
            adjacencyList.get(toNode).add(fromNode);
        }

        public boolean dfs(int theSource, int theDestination) {
            var source = theSource + "";
            var destination = theDestination + "";

            var root = nodes.get(source);

            var set = new HashSet<Node>();
            var stack = new Stack<Node>();

            stack.push(root);

            while (!stack.isEmpty()) {
                var topOfStack = stack.pop();

                if (set.contains(topOfStack))
                    continue;

                set.add(topOfStack);

                for (var neighbor : adjacencyList.get(topOfStack)) {
                    if (neighbor.label.equals(destination))
                        return true;

                    if (!set.contains(neighbor))
                        stack.push(neighbor);
                }
            }

            return false;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1)
            return true;

        var graph = new Graph();

        for (var i = 0; i < n; i++)
            graph.addNode(i + "");

        for (var edge : edges)
            graph.addEdge(edge[0] + "", edge[1] + "");

        return graph.dfs(source, destination);
    }

}