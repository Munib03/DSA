class Solution {
    public static int minimumDifference(int[] nums, int k) {
        var n = nums.length;

        var i = 0;
        var j = k - 1;

        var min = Integer.MAX_VALUE;
        Arrays.sort(nums);

        while (j < n) {
            var me = nums[i];
            var ou = nums[j];

            var currMin = ou - me;
            min = Math.min(min, currMin);

            i++;
            j++;
        }

        return min;
    }
}