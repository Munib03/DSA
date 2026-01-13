class Solution {
    public int lengthOfLIS(int[] nums) {
        var n = nums.length;

        int[][] dp = new int[n + 1][n + 1];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        return matchNotMatch(0, -1, nums, dp);
    }

    private int matchNotMatch(int index, int prev, int[] nums, int[][] dp) {
        if (index == nums.length)
            return 0;

        else if (dp[index][prev + 1] != -1)
            return dp[index][prev + 1];

        var take = 0;

        if (prev == -1 || nums[index] > nums[prev])
            take = 1 + matchNotMatch(index + 1, index, nums, dp);

        var skip = matchNotMatch(index + 1, prev, nums, dp);

        var max = Math.max(skip, take);
        dp[index][prev + 1] = max;

        return max;
    }
}