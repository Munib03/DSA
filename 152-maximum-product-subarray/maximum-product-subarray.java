class Solution {
    public int maxProduct(int[] nums) {
        var n = nums.length;

        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        var maxAns = nums[0];

        for (var i = 1; i < n; i++) {
            var num = nums[i];
            var currMax = num * dpMax[i - 1];
            var currMin = num * dpMin[i - 1];

            dpMax[i] = Math.max(num, Math.max(currMax, currMin));
            dpMin[i] = Math.min(num, Math.min(currMax, currMin));

            maxAns = Math.max(maxAns, dpMax[i]);
        }

        return maxAns;
    }
}