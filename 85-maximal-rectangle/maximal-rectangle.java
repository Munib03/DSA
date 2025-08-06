class Solution {
    public int maximalRectangle(char[][] matrix) {
        var n = matrix.length;
        var m = matrix[0].length;

        int[][] prefixSumArr = new int[n][m];

        for (var i = 0; i < m; i++) {
            var sum = 0;

            for (var j = 0; j < n; j++) {
                if (matrix[j][i] == '0')
                    sum = 0;
                else
                    sum += (matrix[j][i] - '0');

                prefixSumArr[j][i] = sum;
            }
        }

        var max = 0;
        for (var nums : prefixSumArr)
            max = Math.max(max, largestRectangleArea(nums));

        return max;
    }

    public int largestRectangleArea(int[] heights) {
        var pse = prevSmallerElementsIndexes(heights);
        var nse = nextSmallerElementsIndexes(heights);

        var max = 0;
        for (var i = 0; i < heights.length; i++) {
            var left = pse[i];
            var right = nse[i];

            var diff = ((right - left) - 1) * heights[i];
            max = Math.max(max, diff);
        }

        return max;
    }

    public int[] prevSmallerElementsIndexes(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = 0; i < n; i++) {
            var currNum = nums[i];

            while (!monotonicStack.isEmpty() && nums[monotonicStack.peek()] >= currNum)
                monotonicStack.pop();

            ans[i] = (monotonicStack.isEmpty()) ? -1 : monotonicStack.peek();
            monotonicStack.push(i);
        }

        return ans;
    }

    public int[] nextSmallerElementsIndexes(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = n - 1; i >= 0; i--) {
            var currNum = nums[i];

            while (!monotonicStack.isEmpty() && nums[monotonicStack.peek()] >= currNum)
                monotonicStack.pop();

            ans[i] = (monotonicStack.isEmpty()) ? n : monotonicStack.peek();
            monotonicStack.push(i);
        }

        return ans;
    }

}