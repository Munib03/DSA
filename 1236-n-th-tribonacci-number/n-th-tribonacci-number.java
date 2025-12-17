class Solution {
    public int tribonacci(int n) {
        return recFib(n, new HashMap<>());
    }

    private int recFib(int n, Map<Integer, Integer> map) {
        if (n <= 0)
            return 0;

        else if (n == 1 || n == 2)
            return 1;

        else if (map.containsKey(n))
            return map.get(n);

        map.put(n, (recFib(n - 1, map) + recFib(n - 2, map) + recFib(n - 3, map)));

        return map.get(n);
    }
}