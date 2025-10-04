class Solution {
    private class WeightedGraph {
        private class Node {
            private final int label;
            private final List<Edge> edges = new ArrayList<>();

            private Node(int label) {
                this.label = label;
            }

            private void addEdge(Node to, int weight) {
                edges.add(new Edge(to, weight));
            }
        }

        private class Edge {
            private final Node to;
            private final int weight;

            private Edge(Node to, int weight) {
                this.to = to;
                this.weight = weight;
            }
        }

        private final Map<Integer, Node> nodes = new HashMap<>();

        public void addNode(int label) {
            nodes.putIfAbsent(label, new Node(label));
        }

        public void addEdge(int from, int to, int weight) {
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);
            if (fromNode == null || toNode == null)
                return;
            fromNode.addEdge(toNode, weight);
        }

        private record NodeEntry(Node node, int cost, int stops) {
        }

        public int dig(int src, int dst, int maxStops) {
            var fromNode = nodes.get(src);
            var toNode = nodes.get(dst);
            if (fromNode == null || toNode == null)
                return -1;

            var pq = new PriorityQueue<NodeEntry>(Comparator.comparingInt(ne -> ne.cost));
            pq.offer(new NodeEntry(fromNode, 0, -1));

            var dist = new HashMap<Node, Map<Integer, Integer>>();
            for (var node : nodes.values())
                dist.put(node, new HashMap<>());
            dist.get(fromNode).put(0, 0);

            while (!pq.isEmpty()) {
                var top = pq.poll();
                var node = top.node;
                int cost = top.cost;
                int stops = top.stops;

                if (stops > maxStops)
                    continue;

                for (var edge : node.edges) {
                    var next = edge.to;
                    int nextStops = stops + 1;
                    if (nextStops > maxStops)
                        continue;
                    int newCost = cost + edge.weight;

                    int prevCost = dist.get(next).getOrDefault(nextStops, Integer.MAX_VALUE);
                    if (newCost < prevCost) {
                        dist.get(next).put(nextStops, newCost);
                        pq.offer(new NodeEntry(next, newCost, nextStops));
                    }
                }
            }

            int ans = Integer.MAX_VALUE;
            for (int c : dist.get(toNode).values())
                ans = Math.min(ans, c);
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var graph = new WeightedGraph();
        for (int i = 0; i < n; i++)
            graph.addNode(i);
        for (var f : flights)
            graph.addEdge(f[0], f[1], f[2]);
        return graph.dig(src, dst, k);
    }
}
