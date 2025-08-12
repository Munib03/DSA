class Solution {

    public int largestRectangleArea(int[] heights) {
        var n = heights.length;

        var max = 0;
        var pse = previousSmallerElement(heights);
        var nse = nextSmallerElement(heights);

        for (var i = 0; i < n; i++) {
            var left = pse[i];
            var right = nse[i];

            var window = (right - left) - 1;
            var windowSize = window * heights[i];

            max = Math.max(max, windowSize);
        }

        return max;
    }

    public int[] previousSmallerElement(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = 0; i < n; i++) {
            var num = nums[i];

            while (!monotonicStack.isEmpty() && num <= nums[monotonicStack.peek()])
                monotonicStack.pop();

            ans[i] = (monotonicStack.isEmpty()) ? -1 : monotonicStack.peek();
            monotonicStack.push(i);
        }

        return ans;
    }

    public int[] nextSmallerElement(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = n - 1; i >= 0; i--) {
            var num = nums[i];

            while (!monotonicStack.isEmpty() && num <= nums[monotonicStack.peek()])
                monotonicStack.pop();

            ans[i] = (monotonicStack.isEmpty()) ? n : monotonicStack.peek();
            monotonicStack.push(i);
        }

        return ans;
    }
}