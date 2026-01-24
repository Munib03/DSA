class Solution {
    public int minPairSum(int[] nums) {
        var i = 0;
        var j = nums.length - 1;

        var max = Integer.MIN_VALUE;
        Arrays.sort(nums);

        while (i < j) {
            var me = nums[i];
            var ou = nums[j];

            var currMax = me + ou;
            max = Math.max(max, currMax);

            i++;
            j--;
        }

        return max;
    }

}