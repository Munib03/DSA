class Solution {
    public int coinChange(int[] coins, int amount) {
        var ans = takeNotTake(0, 0, amount, coins, new HashMap<>());

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int takeNotTake(int index, int sum, int amount, int[] coins, Map<String, Integer> map) {
        if (sum == amount)
            return 0;

        else if (sum > amount || index >= coins.length)
            return Integer.MAX_VALUE;

        var key = index + ", " + sum;
        if (map.containsKey(key))
            return map.get(key);

        var take = takeNotTake(index, sum + coins[index], amount, coins, map);
        if (take != Integer.MAX_VALUE)
            take = take + 1;

        var notTake = takeNotTake(index + 1, sum, amount, coins, map);

        map.put(key, Math.min(take, notTake));

        return Math.min(take, notTake);
    }
}