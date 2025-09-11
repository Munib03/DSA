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

    }

    public int findJudge(int n, int[][] trust) {
        var graph = new Graph();

        for (var i = 1; i <= n; i++)
            graph.addNode(i + "");

        for (var edge : trust)
            graph.addEdge(edge[0] + "", edge[1] + "");

        var target = -1;
        for (var entry : graph.adjacencyList.entrySet()) {
            var key = entry.getKey().label;
            var val = entry.getValue();

            if (val.isEmpty()) {
                target = Integer.parseInt(key);
                break;
            }
        }

        if (target == -1)
            return -1;

        var node = graph.nodes.get(target + "");
        for (var entry : graph.adjacencyList.entrySet()) {
            var key = entry.getKey();
            var val = entry.getValue();

            if (!key.label.equals(target + "")) {
                if (!val.contains(node))
                    return -1;
            }
        }

        return target;
    }
}