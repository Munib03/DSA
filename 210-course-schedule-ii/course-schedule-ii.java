class Solution {
    private class UnWeightedGraph {
        private class Node {
            private int label;

            private Node(int label) {
                this.label = label;
            }
        }

        private final Map<Integer, Node> nodesMap = new HashMap<>();
        private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

        public void addNode(int label) {
            var newNode = new Node(label);

            nodesMap.putIfAbsent(label, newNode);
            adjacencyList.putIfAbsent(newNode, new ArrayList<>());
        }

        public void addEdge(int from, int to) {
            var fromNode = nodesMap.get(from);
            var toNode = nodesMap.get(to);

            if (fromNode == null || toNode == null)
                return;

            adjacencyList.get(fromNode).add(toNode);
        }

        public boolean hasCycle() {
            var visited = new HashSet<Node>();
            var visiting = new HashSet<Node>();

            for (var node : nodesMap.values())
                if (!visited.contains(node))
                    if (hasCycle(node, visiting, visited))
                        return true;

            return false;
        }

        public int[] topologicalSort() {
            var set = new HashSet<Node>();
            var stack = new Stack<Integer>();

            for (var node : nodesMap.values())
                if (!set.contains(node))
                    topologicalSort(node, set, stack);

            int[] ans = new int[stack.size()];
            var index = 0;

            while (!stack.isEmpty())
                ans[index++] = stack.pop();

            return ans;
        }

        // Inner Detaisl of the class
        private void topologicalSort(Node node, Set<Node> set, Stack<Integer> stack) {
            if (node == null || set.contains(node))
                return;

            set.add(node);

            for (var neighbor : adjacencyList.get(node))
                if (!set.contains(neighbor))
                    topologicalSort(neighbor, set, stack);

            stack.push(node.label);
        }

        private boolean hasCycle(Node node, Set<Node> visiting, Set<Node> visited) {
            visiting.add(node);

            for (var neighbor : adjacencyList.get(node)) {
                if (visited.contains(neighbor))
                    continue;

                else if (visiting.contains(neighbor))
                    return true;

                if (hasCycle(neighbor, visiting, visited))
                    return true;
            }

            visited.add(node);
            visiting.remove(node);

            return false;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var graph = new UnWeightedGraph();

        for (var i = 0; i < numCourses; i++)
            graph.addNode(i);

        for (var edge : prerequisites) {
            graph.addEdge(edge[1], edge[0]);
        }

        if (graph.hasCycle())
            return new int[] {};

        return graph.topologicalSort();
    }

}