class Solution {
    class Graph {
        private class Node {
            private String label;
            private int inputDegree;
            private int outputDegree;

            private Node(String label) {
                this.label = label;
            }

            @Override
            public String toString() {
                return label;
            }
        }

        private Map<String, Node> nodes = new HashMap<>();
        private Map<Node, List<Node>> adjacencyList = new HashMap<>();

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
            fromNode.outputDegree++;
            toNode.inputDegree++;
        }

        public int numberOfComponents() {
            var set = new HashSet<String>();
            var cnt = 0;

            for (var node : nodes.values()) {
                var flag = false;
                var dfs = depthFirstSearch(node, new HashSet<>(), new ArrayList<>());

                for (var sth : dfs) {
                    if (set.contains(sth)) {
                        flag = true;
                        break;
                    } else
                        set.add(sth);
                }

                if (!flag)
                    cnt++;
            }

            return cnt;
        }

        private List<String> depthFirstSearch(Node start, Set<Node> set, List<String> list) {
            if (start == null)
                return list;

            list.add(start.label);
            set.add(start);

            for (var neighbor : adjacencyList.get(start))
                if (!set.contains(neighbor))
                    depthFirstSearch(neighbor, set, list);

            return list;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        var n = isConnected.length;

        var graph = new Graph();

        for (var i = 1; i <= n; i++)
            graph.addNode(i + "");

        for (var i = 0; i < n; i++) {
            var currArray = isConnected[i];

            for (var j = 0; j < currArray.length; j++) {
                var currElement = isConnected[i][j];

                if (currElement == 1)
                    graph.addEdge((i + 1) + "", (j + 1) + "");
            }
        }

        return graph.numberOfComponents();
    }

}