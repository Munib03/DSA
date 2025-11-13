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
            adjacencyList.get(toNode).add(fromNode);
        }

        public boolean isGraphBip() {
            var colorMap = new HashMap<Node, Integer>();
            var queue = new LinkedList<Node>();

            for (var node : nodesMap.values()) {
                if (colorMap.containsKey(node))
                    continue;

                queue.offer(node);
                colorMap.put(node, 0);

                while (!queue.isEmpty()) {
                    var topOfQueue = queue.poll();
                    var color = colorMap.get(topOfQueue);

                    for (var neighbor : adjacencyList.get(topOfQueue)) {
                        if (colorMap.containsKey(neighbor)) {
                            if (colorMap.get(neighbor).equals(color))
                                return false;
                        } else {
                            colorMap.put(neighbor, 1 - color);
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            return true;
        }
    }

    public boolean isBipartite(int[][] graph) {
        var n = graph.length;

        var theRealGraph = new UnWeightedGraph<Integer>();
        for (var i = 0; i < n; i++)
            theRealGraph.addNode(i);

        for (var i = 0; i < n; i++)
            for (var j = 0; j < graph[i].length; j++)
                theRealGraph.addEdge(i, graph[i][j]);

        return theRealGraph.isGraphBip();
    }

}