class Solution {
    private class UnWeightedGraph {
        private class Node {
            private final int label;

            private Node(int label) {
                this.label = label;
            }

            @Override
            public String toString() {
                return String.valueOf(label);
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

        public boolean isGraphBip() {
            var colorMap = new HashMap<Integer, Integer>();
            var queue = new LinkedList<Node>();

            for (var startNode : nodesMap.values()) {
                if (colorMap.containsKey(startNode.label))
                    continue;

                colorMap.put(startNode.label, 0);
                queue.offer(startNode);

                while (!queue.isEmpty()) {
                    var top = queue.poll();
                    int color = colorMap.get(top.label);

                    var neighbors = adjacencyList.get(top);
                    if (neighbors == null)
                        continue;

                    for (var neighbor : neighbors) {
                        if (colorMap.containsKey(neighbor.label)) {
                            if (colorMap.get(neighbor.label) == color)
                                return false;
                        } else {
                            colorMap.put(neighbor.label, 1 - color);
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
        var g = new UnWeightedGraph();
        for (var i = 0; i < n; i++)
            g.addNode(i);

        for (var i = 0; i < n; i++)
            for (var j = 0; j < graph[i].length; j++)
                g.addEdge(i, graph[i][j]);

        return g.isGraphBip();
    }

}