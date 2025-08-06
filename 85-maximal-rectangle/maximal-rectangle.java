class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        var n = matrix.length;
        var m = matrix[0].length;

        int[][] prefixSumArr = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] == '1') {
                    prefixSumArr[j][i] = (j == 0 ? 1 : prefixSumArr[j - 1][i] + 1);
                } else {
                    prefixSumArr[j][i] = 0;
                }
            }
        }

        var max = 0;
        for (var arr : prefixSumArr)
            max = Math.max(max, largestRectangleArea(arr));

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
            while (!monotonicStack.isEmpty() && nums[monotonicStack.peek()] >= nums[i])
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
            while (!monotonicStack.isEmpty() && nums[monotonicStack.peek()] >= nums[i])
                monotonicStack.pop();

            ans[i] = (monotonicStack.isEmpty()) ? n : monotonicStack.peek();
            monotonicStack.push(i);
        }

        return ans;
    }

}