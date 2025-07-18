class Solution {
    public int longestOnes(int[] nums, int k) {
        var n = nums.length;
        var maxLen = 0;

        var left = 0;
        var right = 0;

        var zeroCnt = 0;

        while (right < n) {
            var ou = nums[right];
            if (ou == 0)
                zeroCnt++;

            if (zeroCnt > k) {
                if (nums[left] == 0)
                    zeroCnt--;

                left++;
            }

            if (zeroCnt <= k)
                maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}