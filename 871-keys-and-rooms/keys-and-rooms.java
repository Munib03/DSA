class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        var n = rooms.size();

        var map = new HashMap<Integer, List<Integer>>();
        for (var i = 0; i < n; i++)
            map.put(i, new ArrayList<>());

        for (var i = 0; i < n; i++) {
            var room = rooms.get(i);

            for (var key : room) {
                map.get(i).add(key);
            }
        }

        for (var sth : map.entrySet())
            System.out.println(sth.getKey() + ": " + sth.getValue());

        var ansSet = new HashSet<Integer>();

        dfs(0, map, new HashSet<>(), ansSet);

        return ansSet.size() == n;
    }

    private void dfs(int node,
            Map<Integer, List<Integer>> map,
            Set<Integer> visited,
            Set<Integer> ansSet) {
        if (visited.contains(node))
            return;

        visited.add(node);
        ansSet.add(node);

        for (var neighbor : map.get(node))
            if (!visited.contains(neighbor))
                dfs(neighbor, map, visited, ansSet);

    }
}