class Solution {
    public boolean canPartition(int[] nums) {
        var total = 0;
        for (int num : nums)
            total += num;

        if (total % 2 != 0)
            return false;

        var target = total / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];

        return takeNotTake(0, nums, 0, target, memo);
    }

    private boolean takeNotTake(int index, int[] nums, int sum,
            int target, Boolean[][] memo) {

        if (sum == target)
            return true;

        else if (index >= nums.length || sum > target)
            return false;

        if (memo[index][sum] != null)
            return memo[index][sum];

        var take = takeNotTake(index + 1, nums, sum + nums[index], target, memo);

        var notTake = takeNotTake(index + 1, nums, sum, target, memo);

        return memo[index][sum] = take || notTake;
    }
}
