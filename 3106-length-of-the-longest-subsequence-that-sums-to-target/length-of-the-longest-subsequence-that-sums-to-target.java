class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        var n = nums.size();

        int[] theCoins = new int[n];
        for (var i = 0; i < n; i++)
            theCoins[i] = nums.get(i);

        int[][] memo = new int[n][target + 1];
        for (var sth : memo)
            Arrays.fill(sth, -1);

        var ans = takeNotTake(0, 0, 0, target, theCoins, memo);

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    private int takeNotTake(int index, int count, int sum, int target, int[] nums, int[][] memo) {
        if (sum == target)
            return 0;

        else if (sum > target || index == nums.length)
            return Integer.MIN_VALUE;

        if (memo[index][sum] != -1)
            return memo[index][sum];

        var take = takeNotTake(index + 1, count + 1, sum + nums[index], target, nums, memo);
        if (take != Integer.MIN_VALUE)
            take += 1;

        var notTake = takeNotTake(index + 1, count, sum, target, nums, memo);

        var max = Math.max(take, notTake);
        memo[index][sum] = max;

        return memo[index][sum];
    }

}