import java.util.*;

class Solution {
    public class UnWeightedGraph<T> {
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

        public int numberOfCompleteComponents() {
            var visited = new HashSet<Node>();
            int cnt = 0;

            for (var node : nodesMap.values()) {
                if (!visited.contains(node)) {
                    var list = new ArrayList<T>();
                    numberOfConnectedComponents(node, visited, list);

                    int edgeCount = 0;
                    for (var label : list) {
                        var n = nodesMap.get(label);
                        edgeCount += adjacencyList.get(n).size();
                    }
                    edgeCount /= 2;

                    int k = list.size();
                    if (edgeCount == k * (k - 1) / 2)
                        cnt++;
                }
            }

            return cnt;
        }

        // Inner Details of the class
        private void numberOfConnectedComponents(Node node, Set<Node> set, List<T> list) {
            if (node == null || set.contains(node))
                return;

            set.add(node);
            list.add(node.label);

            for (var neighbor : adjacencyList.get(node))
                if (!set.contains(neighbor))
                    numberOfConnectedComponents(neighbor, set, list);

        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        var graph = new UnWeightedGraph<Integer>();

        for (var i = 0; i < n; i++)
            graph.addNode(i);

        for (var edge : edges)
            graph.addEdge(edge[0], edge[1]);

        return graph.numberOfCompleteComponents();
    }
}
