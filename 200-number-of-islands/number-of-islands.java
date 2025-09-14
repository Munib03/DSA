class Solution {
    class Graph {
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

        private Set<Node> set = new HashSet<>();

        public int numberOfConnectedComp(int n) {
            var cnt = 0;

            for (var node : nodes.values()) {
                if (!set.contains(node)) {
                    cnt++;
                    dfs(node);
                }
            }

            return cnt;
        }

        private void dfs(Node root) {
            if (root == null || set.contains(root))
                return;

            set.add(root);
            for (var neighbor : adjacencyList.get(root))
                if (!set.contains(neighbor))
                    dfs(neighbor);

        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Graph graph = new Graph();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    graph.addNode(i + "_" + j);
                }
            }
        }

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    for (var dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == '1') {
                            graph.addEdge(i + "_" + j, ni + "_" + nj);
                        }
                    }
                }
            }
        }

        return graph.numberOfConnectedComp(n);
    }
}