class Solution {
    public int longestOnes(int[] nums, int k) {
        var n = nums.length;
        var maxLen = 0;

        for (var i = 0; i < n; i++) {
            var numOfZeros = 0;

            for (var j = i; j < n; j++) {
                if (nums[j] == 0)
                    numOfZeros++;

                if (numOfZeros <= k)
                    maxLen = Math.max(maxLen, j - i + 1);
                else
                    break;
            }
        }

        return maxLen;
    }
}