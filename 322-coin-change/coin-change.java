class Solution {
    public int coinChange(int[] coins, int amount) {
        var n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        var ans = pickNotPick(0, 0, coins, amount, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int pickNotPick(int index, int currSum, int[] nums, int target, int[][] dp) {
        if (index >= nums.length || currSum > target)
            return Integer.MAX_VALUE;

        else if (target == currSum)
            return 0;

        else if (dp[index][currSum] != -1)
            return dp[index][currSum];

        var pick = Integer.MAX_VALUE;
        if (nums[index] <= target - currSum) {
            pick = pickNotPick(index, currSum + nums[index], nums, target, dp);

            if (pick != Integer.MAX_VALUE)
                pick += 1;
        }

        var notPick = pickNotPick(index + 1, currSum, nums, target, dp);

        var min = Math.min(pick, notPick);
        dp[index][currSum] = min;

        return min;
    }
}