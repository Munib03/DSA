class Solution {
    public class UnWeightedGraph {
        private static class Node {
            private final int val;

            private Node(int val) {
                this.val = val;
            }

            @Override
            public String toString() {
                return this.val + "";
            }
        }

        private final Map<Integer, Node> nodes = new HashMap<>();
        private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

        public void addNode(int val) {
            var newNode = new Node(val);

            nodes.putIfAbsent(val, newNode);
            adjacencyList.putIfAbsent(newNode, new ArrayList<>());
        }

        public void addEdge(int from, int to) {
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);

            if (fromNode == null || toNode == null)
                throw new IllegalArgumentException();

            adjacencyList.get(fromNode).add(toNode);
        }

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            var n = rooms.size();

            for (var i = 0; i < n; i++)
                this.addNode(i);

            for (var i = 0; i < n; i++) {
                for (var j = 0; j < rooms.get(i).size(); j++) {
                    this.addEdge(i, rooms.get(i).get(j));
                }
            }

            var ansSet = new HashSet<Node>();
            dfs(nodes.get(0), new HashSet<>(), ansSet);

            return ansSet.size() == n;
        }

        private void dfs(Node node, Set<Node> set, Set<Node> ansSet) {
            if (node == null)
                return;

            set.add(node);
            ansSet.add(node);
            for (var neighbor : adjacencyList.get(node))
                if (!set.contains(neighbor))
                    dfs(neighbor, set, ansSet);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        var obj = new UnWeightedGraph();

        return obj.canVisitAllRooms(rooms);
    }
}