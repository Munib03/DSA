class Solution {
    class Graph {
        private class Node {
            private final String label;

            private Node(String label) {
                this.label = label;
            }

            @Override
            public String toString() {
                return label;
            }
        }

        private final Map<String, Node> nodes = new HashMap<>();
        private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

        public void addNode(String label) {
            var newNode = new Node(label);

            nodes.putIfAbsent(label, newNode);
            adjacencyList.putIfAbsent(newNode, new ArrayList<>());
        }

        public void addEdge(String from, String to) {
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);

            if (fromNode == null || toNode == null)
                return;

            adjacencyList.get(fromNode).add(toNode);
        }

        public boolean isBipartiteGraph() {
            var map = new HashMap<String, Integer>();

            for (var node : nodes.values()) {
                if (!map.containsKey(node.label)) {
                    if (!dfs(node, map, 0))
                        return false;
                }
            }

            return true;
        }

        // Inner Details of the class
        private boolean dfs(Node root, Map<String, Integer> map, int color) {
            map.putIfAbsent(root.label, color);

            for (var neighbor : adjacencyList.get(root)) {
                if (map.containsKey(neighbor.label)) {
                    if (map.get(neighbor.label) == color)
                        return false;
                } else {
                    var res = dfs(neighbor, map, 1 - color);
                    if (!res)
                        return false;
                }
            }

            return true;
        }
    }

    public boolean isBipartite(int[][] graph) {
        var n = graph.length;

        var theRealGraph = new Graph();
        for (var i = 0; i < n; i++)
            theRealGraph.addNode(i + "");

        for (int i = 0; i < graph.length; i++) {
            for (int neighbor : graph[i]) {
                theRealGraph.addEdge(i + "", neighbor + "");
            }
        }

        return theRealGraph.isBipartiteGraph();
    }

}