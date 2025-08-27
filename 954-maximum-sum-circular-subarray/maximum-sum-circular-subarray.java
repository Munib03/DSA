class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        var maxSum = nums[0];
        var curMax = 0;
        var minSum = nums[0];
        var curMin = 0;

        for (int a : nums) {
            curMax = Math.max(a, curMax + a);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(a, curMin + a);
            minSum = Math.min(minSum, curMin);

            total += a;
        }

        if (maxSum < 0)
            return maxSum;

        return Math.max(maxSum, total - minSum);
    }

}