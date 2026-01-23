class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if (amount == 0)
            return 0;

        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int ans = pickNotPick(0, 0, coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int pickNotPick(int index, int currSum, int[] nums,
                            int target, int[][] dp) {

        if (currSum == target)
            return 0;

        if (index >= nums.length || currSum > target)
            return Integer.MAX_VALUE;

        if (dp[index][currSum] != -1)
            return dp[index][currSum];

        int pick = Integer.MAX_VALUE;
        if (nums[index] <= target - currSum) {
            pick = pickNotPick(index, currSum + nums[index], nums, target, dp);
            if (pick != Integer.MAX_VALUE)
                pick += 1;
        }

        int notPick = pickNotPick(index + 1, currSum, nums, target, dp);

        return dp[index][currSum] = Math.min(pick, notPick);
    }
}
