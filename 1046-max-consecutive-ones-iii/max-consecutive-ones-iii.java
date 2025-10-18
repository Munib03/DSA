class Solution {
    public int longestOnes(int[] nums, int k) {
        var n = nums.length;

        int[] freqArr = new int[2];
        var maxLen = 0;

        var left = 0;
        var right = 0;

        while (left < n && right < n) {
            var currNum = nums[right];

            freqArr[currNum]++;

            while (freqArr[0] > k) {
                freqArr[nums[left]]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}