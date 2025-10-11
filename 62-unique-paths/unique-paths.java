class Solution {
    public int uniquePaths(int m, int n) {
        return rec(m, n, 0, 0, new HashMap<>());
    }

    private int rec(int m, int n, int row, int col, Map<String, Integer> map) {
        if (row >= m || col >= n)
            return 0;

        else if (row == m - 1 && col == n - 1)
            return 1;

        var key = row + ", " + col;
        if (map.containsKey(key))
            return map.get(key);

        var down = rec(m, n, row + 1, col, map);
        var right = rec(m, n, row, col + 1, map);

        map.put(key, down + right);

        return map.get(key);
    }
}