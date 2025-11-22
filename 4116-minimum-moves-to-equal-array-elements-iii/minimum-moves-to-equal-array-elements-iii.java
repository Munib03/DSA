class Solution {
    public int minMoves(int[] nums) {
        var max = Integer.MIN_VALUE;

        for (var num : nums)
            max = Math.max(max, num);

        var cnt = 0;
        for (var num : nums)
            cnt += Math.abs(num - max);

        return cnt;
    }

}