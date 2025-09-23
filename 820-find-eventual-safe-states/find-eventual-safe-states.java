class Solution {
    class Graph {
        private class Node {
            private final int label;
            private final int hash;

            private Node(int label) {
                this.label = label;
                this.hash = Integer.hashCode(label);
            }

            @Override
            public int hashCode() {
                return hash;
            }

            @Override
            public boolean equals(Object o) {
                return this == o || (o instanceof Node n && n.label == label);
            }

            @Override
            public String toString() {
                return String.valueOf(label);
            }
        }

        private final Map<Integer, Node> nodes;
        private final Map<Node, List<Node>> adjacencyList;

        public Graph(int n) {
            nodes = new HashMap<>(n);
            adjacencyList = new HashMap<>(n);
        }

        public void addNode(int label) {
            var newNode = new Node(label);
            nodes.putIfAbsent(label, newNode);
            adjacencyList.putIfAbsent(newNode, new ArrayList<>());
        }

        public void addEdge(int from, int to) {
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);
            if (fromNode == null || toNode == null)
                return;
            adjacencyList.get(fromNode).add(toNode);
        }

        private Set<Node> hasCycle() {
            var visited = new HashSet<Node>(nodes.size());
            var theNerds = new HashSet<Node>(nodes.size());
            for (var currNode : nodes.values()) {
                if (!visited.contains(currNode))
                    hasCycle(currNode, new HashSet<Node>(nodes.size()), visited, theNerds);
            }
            return theNerds;
        }

        private boolean hasCycle(Node node, Set<Node> visiting, Set<Node> visited, Set<Node> areNotSafeState) {
            visiting.add(node);
            for (var neighbor : adjacencyList.get(node)) {
                if (visited.contains(neighbor))
                    continue;
                else if (visiting.contains(neighbor)) {
                    areNotSafeState.addAll(visiting);
                    return true;
                }
                if (hasCycle(neighbor, visiting, visited, areNotSafeState))
                    return true;
            }
            visiting.remove(node);
            visited.add(node);
            return false;
        }
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        var n = graph.length;
        var theRealGraph = new Graph(n);
        for (var i = 0; i < n; i++)
            theRealGraph.addNode(i);
        for (var i = 0; i < n; i++)
            for (var j = 0; j < graph[i].length; j++)
                theRealGraph.addEdge(i, graph[i][j]);
        var list = new ArrayList<Integer>();
        var theNotSafeOnes = theRealGraph.hasCycle();
        for (var i = 0; i < n; i++)
            if (!theNotSafeOnes.contains(theRealGraph.nodes.get(i)))
                list.add(i);
        return list;
    }

}