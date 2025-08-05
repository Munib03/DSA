class Solution {
    public long subArrayRanges(int[] nums) {
        var n = nums.length;
        var sum = 0L;

        for (var i = 0; i < n; i++) {
            var min = nums[i];
            var max = nums[i];

            for (var j = i; j < n; j++) {
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);

                sum += max - min;
            }
        }

        return sum;
    }
}