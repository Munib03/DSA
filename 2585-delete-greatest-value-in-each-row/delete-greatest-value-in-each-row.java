class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for (int[] nums : grid)
            Arrays.sort(nums);

        var ans = 0;
        for (var i = 0; i < grid[0].length; i++) {
            var max = Integer.MIN_VALUE;

            for (var j = 0; j < grid.length; j++)
                max = Math.max(max, grid[j][i]);

            ans += max;
        }

        return ans;
    }
}