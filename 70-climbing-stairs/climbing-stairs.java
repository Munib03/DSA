class Solution {
    public int climbStairs(int n) {
        return rec(n, new HashMap<>());
    }

    private int rec(int n, Map<Integer, Integer> map) {
        if (n <= 2)
            return n;

        else if (map.containsKey(n))
            return map.get(n);

        map.put(n, (rec(n - 1, map) + rec(n - 2, map)));

        return map.get(n);
    }
}