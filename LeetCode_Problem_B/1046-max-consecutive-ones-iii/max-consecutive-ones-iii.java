class Solution {
    public int longestOnes(int[] nums, int k) {
        var n = nums.length;
        var maxLen = 0;

        var left = 0;
        var right = 0;

        var flag = true;

        var zeroCnt = 0;
        while (right < n) {
            var ou = nums[right];
            if (ou == 0 && flag)
                zeroCnt++;

            if (zeroCnt > k) {
                flag = false;
                if (nums[left] == 0)
                    zeroCnt--;

                left++;
            }

            else {
                flag = true;
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }
        }

        return maxLen;
    }
}