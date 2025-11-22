class Solution {
    public int minMoves2(int[] nums) {
        var n = nums.length;
        Arrays.sort(nums);

        var cnt = 0;
        var mid = nums[n / 2];

        for (var num : nums)
            cnt += Math.abs(num - mid);

        return cnt;
    }
}