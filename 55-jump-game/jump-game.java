class Solution {
    public boolean canJump(int[] nums) {
        var n = nums.length;

        var maxIndex = 0;

        for (var i = 0; i < n; i++) {
            var num = nums[i];

            if (i > maxIndex)
                return false;

            maxIndex = Math.max(maxIndex, num + i);
        }

        return true;
    }
}