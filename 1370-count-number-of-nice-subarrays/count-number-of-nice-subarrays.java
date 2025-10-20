class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countNumberOfSubArraysEqualOrLessThanK(nums, k) - countNumberOfSubArraysEqualOrLessThanK(nums, k - 1);
    }

    private int countNumberOfSubArraysEqualOrLessThanK(int[] nums, int k) {
        if (k < 0)
            return 0;

        var n = nums.length;

        var cnt = 0;
        var sum = 0;

        var left = 0;
        var right = 0;

        while (right < n) {
            var currNum = nums[right];

            sum += currNum % 2;
            while (sum > k) {
                var me = nums[left] % 2;

                sum -= me;
                left++;
            }

            cnt += (right - left) + 1;
            right++;
        }

        return cnt;
    }
}