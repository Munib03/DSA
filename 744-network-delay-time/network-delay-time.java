class Solution {
    private static class WeightedGraph<T> {
        private class Node {
            private final T label;
            private final List<Edge> edges = new ArrayList<>();

            private Node(T label) {
                this.label = label;
            }

            public void addEdge(Node to, int weight) {
                this.edges.add(new Edge(this, to, weight));
            }

            @Override
            public String toString() {
                return label.toString();
            }
        }

        private class Edge {
            private final Node from;
            private final Node to;
            private final int weight;

            private Edge(Node from, Node to, int weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }

            @Override
            public String toString() {
                return from + " -> " + to;
            }
        }

        private final Map<T, Node> nodes = new HashMap<>();

        public void addNode(T label) {
            var newNode = new Node(label);
            nodes.putIfAbsent(label, newNode);
        }

        public void addEdge(T from, T to, int weight) {
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);

            if (fromNode == null || toNode == null)
                return;

            fromNode.addEdge(toNode, weight);
        }

        public int getShortestPath(T from, T to) {
            var fromNode = nodes.get(from);

            var pq = new PriorityQueue<NodeEntry>(
                    Comparator.comparingInt(ne -> ne.priority));

            var distanceMap = new HashMap<Node, Integer>();
            for (var node : nodes.values())
                distanceMap.put(node, Integer.MAX_VALUE);

            distanceMap.replace(fromNode, 0);

            var set = new HashSet<Node>();
            pq.offer(new NodeEntry(fromNode, 0));

            while (!pq.isEmpty()) {
                var current = pq.remove().node;
                set.add(current);

                for (var edge : current.edges) {
                    if (set.contains(edge.to))
                        continue;

                    var newDistance = distanceMap.get(current) + edge.weight;
                    if (newDistance < distanceMap.get(edge.to)) {
                        distanceMap.replace(edge.to, newDistance);
                        pq.offer(new NodeEntry(edge.to, newDistance));
                    }
                }
            }

            var min = -1;
            for (var val : distanceMap.values())
                if (val != Integer.MAX_VALUE && val > min)
                    min = val;

            return min;
        }

        // Inner Details of the class
        private class NodeEntry {
            private final Node node;
            private final int priority;

            private NodeEntry(Node node, int priority) {
                this.node = node;
                this.priority = priority;
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        var graph = new WeightedGraph<Integer>();

        for (var i = 1; i <= n; i++)
            graph.addNode(i);

        var set = new HashSet<Integer>();
        for (var time : times) {
            var to = time[1];
            if (to != k)
                set.add(to);

            graph.addEdge(time[0], to, time[2]);
        }

        if (set.size() < n-1)
            return -1;

        return graph.getShortestPath(k, n);
    }

}