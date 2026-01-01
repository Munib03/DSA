class Solution {
    public int coinChange(int[] coins, int amount) {
        var ans = takeNotTake(0, 0, amount, coins, new HashMap<>());

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int takeNotTake(int index, int sum, int target, int[] coins, Map<String, Integer> map) {
        if (sum == target)
            return 0;

        else if (sum > target || index == coins.length)
            return Integer.MAX_VALUE;

        var key = index + ", " + sum;
        if (map.containsKey(key))
            return map.get(key);

        var take = takeNotTake(index, sum + coins[index], target, coins, map);
        if (take != Integer.MAX_VALUE)
            take += 1;

        var notTake = takeNotTake(index + 1, sum, target, coins, map);

        var min = Math.min(take, notTake);
        map.put(key, min);

        return min;
    }
}