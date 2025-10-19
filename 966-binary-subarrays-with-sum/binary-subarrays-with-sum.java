class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findLessOrEqualToGoal(nums, goal) - findLessOrEqualToGoal(nums, goal - 1);
    }

    private int findLessOrEqualToGoal(int[] nums, int goal) {
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
                sum -= nums[left++];
            }

            cnt += (right - left) + 1;
            right++;
        }

        return cnt;
    }

}