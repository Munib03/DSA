class Solution {
    public int minDifference(int[] nums) {
        var n = nums.length;
        if (n <= 3)
            return 0;

        Arrays.sort(nums);
        var minDiff = Integer.MAX_VALUE;

        minDiff = Math.min(minDiff, nums[n - 4] - nums[0]);

        minDiff = Math.min(minDiff, nums[n - 1] - nums[3]);

        minDiff = Math.min(minDiff, nums[n - 3] - nums[1]);

        minDiff = Math.min(minDiff, nums[n - 2] - nums[2]);

        return minDiff;
    }
}