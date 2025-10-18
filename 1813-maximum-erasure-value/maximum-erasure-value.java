class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        var n = nums.length;

        int[] freqArray = new int[10001];
        var maxSum = 0;
        var currSum = 0;

        var left = 0;
        var right = 0;

        while (right < n) {
            var currNum = nums[right];

            freqArray[currNum]++;
            currSum += currNum;
            var currNumFreq = freqArray[currNum];

            if (currNumFreq > 1) {
                while (freqArray[currNum] > 1) {
                    var me = nums[left];
                    freqArray[me]--;
                    currSum -= me;
                    left++;
                }
            } else {
                maxSum = Math.max(maxSum, currSum);
            }

            right++;
        }

        return maxSum;
    }

}