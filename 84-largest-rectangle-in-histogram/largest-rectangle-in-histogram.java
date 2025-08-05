class Solution {
    public int largestRectangleArea(int[] heights) {
        var psi = prevSmallIndexes(heights);
        var nsi = nextSmallIndexes(heights);

        var totalAns = 0;
        for (var i = 0; i < heights.length; i++) {
            var left = psi[i];
            var right = nsi[i];

            var diff = Math.max((right - left) - 1, 0) * heights[i];
            totalAns = Math.max(totalAns, diff);
        }

        return totalAns;
    }

    public int[] prevSmallIndexes(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = 0; i < n; i++) {
            var num = nums[i];

            while (!monotonicStack.isEmpty() && nums[monotonicStack.peek()] >= num)
                monotonicStack.pop();

            ans[i] = (monotonicStack.isEmpty()) ? -1 : monotonicStack.peek();
            monotonicStack.push(i);
        }

        return ans;
    }

    public int[] nextSmallIndexes(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = n - 1; i >= 0; i--) {
            var num = nums[i];

            while (!monotonicStack.isEmpty() && nums[monotonicStack.peek()] >= num)
                monotonicStack.pop();

            ans[i] = (monotonicStack.isEmpty()) ? n : monotonicStack.peek();
            monotonicStack.push(i);
        }

        return ans;
    }

}