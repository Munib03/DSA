class Solution {

    class DirectedGraph {
        private record Node(String label) {
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

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        public List<List<Integer>> dfs(int n) {
            dfs(nodes.get("0"), 0, n - 1, new HashSet<>());

            return ans;
        }

        // Inner details of the class
        private void dfs(Node root, int start, int target, Set<Node> set) {
            if (root == null || set.contains(root))
                return;

            tempList.add(Integer.parseInt(root.label));
            if (root.label.equals(target + "")) {
                var copy = new ArrayList<>(tempList);
                ans.add(copy);
            }

            for (var neighbor : adjacencyList.get(root))
                if (!set.contains(neighbor))
                    dfs(neighbor, start, target, set);

            tempList.removeLast();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        var n = graph.length;
        var theGraph = new DirectedGraph();

        for (var node = 0; node < n; node++)
            theGraph.addNode(node + "");

        for (var i = 0; i < n; i++) {
            var adjList = graph[i];

            for (int k : adjList)
                theGraph.addEdge(i + "", k + "");
        }

        return theGraph.dfs(n);
    }
}