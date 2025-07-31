class Solution {
    public int[] nextGreaterElements(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];

        for (var i = 0; i < n; i++) {
            var flag = false;

            for (var j = i + 1; j < i + n; j++) {
                if (nums[j % n] > nums[i]) {
                    ans[i] = nums[j % n];
                    flag = true;
                    break;
                }
            }

            if (!flag)
                ans[i] = -1;
        }

        return ans;
    }
}