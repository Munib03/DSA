class Solution {
    public int change(int amount, int[] coins) {
        var n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        return takeNotTake(0, 0, coins, amount, dp);
    }

    private int takeNotTake(int index, int currSum, int[] nums, int target, int[][] dp) {
        if (index >= nums.length || currSum > target)
            return 0;

        else if (currSum == target)
            return 1;

        else if (dp[index][currSum] != -1)
            return dp[index][currSum];

        currSum += nums[index];
        var pick = takeNotTake(index, currSum, nums, target, dp);

        currSum -= nums[index];
        var notPick = takeNotTake(index + 1, currSum, nums, target, dp);

        var sum = pick + notPick;
        dp[index][currSum] = sum;

        return sum;
    }
}