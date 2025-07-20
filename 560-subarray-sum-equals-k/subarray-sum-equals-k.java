class Solution {
    public int subarraySum(int[] nums, int k) {
        var n = nums.length;

        var cnt = 0;

        for (var i = 0; i < n; i++) {
            var sum = 0;

            for (var j = i; j < n; j++) {
                sum += nums[j];

                if (sum == k)
                    cnt++;
            }
        }

        return cnt;
    }
}