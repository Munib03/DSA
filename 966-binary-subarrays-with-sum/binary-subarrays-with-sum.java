class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        var ans1 = finder(nums, goal);
        var ans2 = finder(nums, goal - 1);

        return ans1 - ans2;
    }

    private int finder(int[] nums, int goal) {
        if (goal < 0)
            return 0;

        var n = nums.length;

        var cnt = 0;
        var sum = 0;

        var left = 0;
        var right = 0;

        while (right < n) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            cnt += right - left + 1;

            right++;
        }

        return cnt;
    }
}