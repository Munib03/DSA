class Solution {
    public int minimumDeletions(int[] nums) {
        var n = nums.length;

        var minIndex = 0;
        var maxIndex = 0;

        for (var i=0; i < n; i++) {
            var num = nums[i];

            if (num > nums[maxIndex])
                maxIndex = i;

            if (num < nums[minIndex])
                minIndex = i;
        }

        var l = Math.min(minIndex, maxIndex);
        var r = Math.max(minIndex, maxIndex);

        return Math.min(Math.min(r + 1, n - l), l+ 1 + n - r);
    }
}