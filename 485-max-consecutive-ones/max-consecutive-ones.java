class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        var n = nums.length;
        var maxLen = 0;

        var left = 0;
        var right = 0;

        while (left < n && right < n) {
            var num = nums[right];

            if (num == 1) {
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                left = right;
                left++;
            }

            right++;
        }

        return maxLen;
    }
}