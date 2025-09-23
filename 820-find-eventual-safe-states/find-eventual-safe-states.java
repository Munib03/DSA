class Solution {
    private final List<List<Integer>> adjacencyList = new ArrayList<>();

    public List<Integer> eventualSafeNodes(int[][] graph) {
        var n = graph.length;

        for (var i = 0; i < n; i++)
            adjacencyList.add(new ArrayList<>());

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < graph[i].length; j++)
                adjacencyList.get(i).add(graph[i][j]);
        }

        var theNotSafeStates = hasCycle(n);
        var ansList = new ArrayList<Integer>();
        for (var i = 0; i < n; i++)
            if (!theNotSafeStates.contains(i))
                ansList.add(i);

        return ansList;
    }

    private Set<Integer> hasCycle(int n) {
        var theNotSafeStates = new HashSet<Integer>();
        var visiting = new HashSet<Integer>();
        var visited = new HashSet<Integer>();

        for (var i = 0; i < n; i++) {
            if (!visited.contains(i) && !theNotSafeStates.contains(i)) {
                hasCycle(i, new HashSet<>(), visited, theNotSafeStates);
            }
        }

        return theNotSafeStates;
    }

    private boolean hasCycle(int node, Set<Integer> visiting, Set<Integer> visited, Set<Integer> theNotSafeStates) {
        visiting.add(node);

        for (var neighbor : adjacencyList.get(node)) {
            if (visited.contains(neighbor))
                continue;

            else if (visiting.contains(neighbor)) {
                theNotSafeStates.addAll(visiting);
                return true;
            }

            var res = hasCycle(neighbor, visiting, visited, theNotSafeStates);
            if (res)
                return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }
}