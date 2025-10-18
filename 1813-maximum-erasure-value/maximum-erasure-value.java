class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        var n = nums.length;

        var map = new HashMap<Integer, Integer>();
        var maxSum = 0;
        var currSum = 0;

        var left = 0;
        var right = 0;

        while (right < n) {
            var currNum = nums[right];

            map.put(currNum, map.getOrDefault(currNum, 0) + 1);
            currSum += currNum;
            var currNumFreq = map.getOrDefault(currNum, 0);

            if (currNumFreq > 1) {
                while (map.get(currNum) > 1) {
                    var me = nums[left];
                    map.put(me, map.get(me) - 1);

                    currSum -= me;
                    if (map.get(me) == 0)
                        map.remove(me);

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