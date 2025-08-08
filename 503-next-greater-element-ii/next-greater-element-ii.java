class Solution {
    public int[] nextGreaterElements(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];

        for (var i = 0; i < n; i++) {
            var flag = false;

            for (var j = i + 1; j < n + i; j++) {
                var index = j % n;

                if (nums[index] > nums[i]) {
                    flag = true;
                    ans[i] = nums[index];
                    break;
                }
            }

            if (!flag)
                ans[i] = -1;
        }

        return ans;
    }
}