class Solution {
    public int deleteGreatestValue(int[][] grid) {
        var n = grid[0].length;

        var ans = 0;
        while (n >= 1) {
            var max = 0;

            for (int[] nums : grid) {
                Arrays.sort(nums);

                max = Math.max(max, nums[nums.length - 1]);
                nums[nums.length - 1] = Integer.MIN_VALUE;
            }

            ans += max;
            n--;
        }

        return ans;
    }
}