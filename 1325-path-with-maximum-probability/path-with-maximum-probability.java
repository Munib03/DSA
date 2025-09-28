import java.util.*;

class Solution {
    private static class WeightedGraph<T> {
        private class Node {
            private final T label;
            private final List<Edge> edges = new ArrayList<>();

            private Node(T label) {
                this.label = label;
            }

            public void addEdge(Node to, double weight) {
                this.edges.add(new Edge(to, weight));
            }

            @Override
            public String toString() {
                return label.toString();
            }
        }

        private class Edge {
            private final Node to;
            private final double weight;

            private Edge(Node to, double weight) {
                this.to = to;
                this.weight = weight;
            }
        }

        private final Map<T, Node> nodes = new HashMap<>();

        public void addNode(T label) {
            var newNode = new Node(label);
            nodes.putIfAbsent(label, newNode);
        }

        public void addEdge(T from, T to, double weight) {
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);

            if (fromNode == null || toNode == null)
                return;

            fromNode.addEdge(toNode, weight);
            toNode.addEdge(fromNode, weight);
        }

        public double shortestPath(T source, T destination) {
            var sourceNode = nodes.get(source);
            var destinationNode = nodes.get(destination);

            if (sourceNode == null || destinationNode == null)
                return 0.0;

            var distanceMap = new HashMap<Node, Double>();
            for (var node : nodes.values())
                distanceMap.put(node, 0.0);
            distanceMap.put(sourceNode, 1.0);

            var pq = new PriorityQueue<NodeEntry>(
                    (a, b) -> Double.compare(b.priority, a.priority));
            pq.offer(new NodeEntry(sourceNode, 1.0));

            while (!pq.isEmpty()) {
                var currTopNode = pq.poll().node;

                for (var edge : currTopNode.edges) {
                    var newProb = distanceMap.get(currTopNode) * edge.weight;
                    if (newProb > distanceMap.get(edge.to)) {
                        distanceMap.put(edge.to, newProb);
                        pq.offer(new NodeEntry(edge.to, newProb));
                    }
                }
            }

            return distanceMap.get(destinationNode);
        }

        private class NodeEntry {
            private final Node node;
            private final double priority;

            private NodeEntry(Node node, double priority) {
                this.node = node;
                this.priority = priority;
            }
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        var graph = new WeightedGraph<Integer>();

        for (var i = 0; i < n; i++)
            graph.addNode(i);

        var index = 0;
        for (var edge : edges)
            graph.addEdge(edge[0], edge[1], succProb[index++]);

        return graph.shortestPath(start_node, end_node);
    }
}
