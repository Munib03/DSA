class Solution {
    private class Graph {
        private class Node {
            private int label;

            private Node(int label) {
                this.label = label;
            }

            @Override
            public String toString() {
                return label + "";
            }
        }

        private final Map<Integer, Node> nodes = new HashMap<>();
        private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

        public void addNode(int label) {
            var newNode = new Node(label);

            nodes.putIfAbsent(label, newNode);
            adjacencyList.put(newNode, new ArrayList<>());
        }

        public void addEdge(int from, int to) {
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);

            if (fromNode == null || toNode == null)
                return;

            adjacencyList.get(fromNode).add(toNode);
        }

        public boolean hasCycle() {
            var visiting = new HashSet<Node>();
            var visited = new HashSet<Node>();

            for (var node : nodes.values()) {
                if (hasCycle(node, visiting, visited))
                    return true;
            }

            return false;
        }

        public int[] topologicalSort() {
            var set = new HashSet<Node>();
            var stack = new Stack<Node>();

            for (var node : nodes.values()) {
                if (!set.contains(node))
                    topologicalSort(node, set, stack);
            }

            int[] ansNums = new int[stack.size()];
            var index = 0;
            while (!stack.isEmpty())
                ansNums[index++] = stack.pop().label;

            return ansNums;
        }

        // Inner Details
        private void topologicalSort(Node node, Set<Node> set, Stack<Node> stack) {
            if (node == null || set.contains(node))
                return;

            set.add(node);

            for (var neighbor : adjacencyList.get(node))
                if (!set.contains(neighbor))
                    topologicalSort(neighbor, set, stack);

            stack.push(node);
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

            visiting.remove(node);
            visited.add(node);

            return false;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var graph = new Graph();

        for (var i = 0; i < numCourses; i++)
            graph.addNode(i);

        for (var edge : prerequisites)
            graph.addEdge(edge[1], edge[0]);

        if (graph.hasCycle())
            return new int[] {};

        return graph.topologicalSort();
    }

}