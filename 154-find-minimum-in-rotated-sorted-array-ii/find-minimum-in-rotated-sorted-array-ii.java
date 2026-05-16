class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        var n = nums.length;

        var left = 0;
        var right = n - 1;

        while (left < right) {
            var mid = left + (right - left) / 2;

            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }

        return nums[left];
    }
}