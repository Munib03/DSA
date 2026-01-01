class Solution {
    public int change(int amount, int[] coins) {
        return takeNotTake(0, 0, amount, coins, new HashMap<>());
    }

    private int takeNotTake(int index, int sum, int amount, int[] coins, Map<String, Integer> memo) {
        if (sum == amount)
            return 1;

        else if (sum > amount || index >= coins.length)
            return 0;

        var key = index + ", " + sum;
        if (memo.containsKey(key))
            return memo.get(key);

        sum += coins[index];
        var take = takeNotTake(index, sum, amount, coins, memo);

        sum -= coins[index];
        var notTake = takeNotTake(index + 1, sum, amount, coins, memo);

        var totalWays = take + notTake;
        memo.put(key, totalWays);

        return totalWays;
    }
}