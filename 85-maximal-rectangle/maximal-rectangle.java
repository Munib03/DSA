class Solution {
public int maximalRectangle(char[][] matrix) {
  var thePrefixSumArr = prefixSum(matrix);

  var maxArea = 0;
  for (var theMat : thePrefixSumArr)
    maxArea = Math.max(largestRectangleArea(theMat), maxArea);

  return maxArea;
}

private int[][] prefixSum(char[][] mat) {
  var n = mat.length;
  var m = mat[0].length;

  int[][] ans = new int[n][m];

  for (var i = 0; i < m; i++) {
    var sum = 0;

    for (var j = 0; j < n; j++) {
      var curr = mat[j][i];

      if (curr == '0')
        sum = 0;
      else
        sum += 1;

      ans[j][i] = sum;
    }
  }


  return ans;
}

public int largestRectangleArea(int[] heights) {
  var n = heights.length;

  var pse = previousSmallerElementsIndex(heights);
  var nse = nextSmallerElementsIndex(heights);

  var max = 0;

  for (var i = 0; i < n; i++) {
    var currPSE = pse[i];
    var currNSE = nse[i];

    var window = (currNSE - currPSE) - 1;
    var currMax = window * heights[i];

    max = Math.max(max, currMax);
  }

  return max;
}


private int[] previousSmallerElementsIndex(int[] nums) {
  var n = nums.length;

  int[] ans = new int[n];
  var stack = new Stack<Integer>();

  for (var i = 0; i < n; i++) {
    var currNum = nums[i];

    while (!stack.isEmpty() && currNum <= nums[stack.peek()])
      stack.pop();

    ans[i] = stack.isEmpty() ? -1 : stack.peek();
    stack.push(i);
  }

  return ans;
}

private int[] nextSmallerElementsIndex(int[] nums) {
  var n = nums.length;

  int[] ans = new int[n];
  var stack = new Stack<Integer>();

  for (var i = n - 1; i >= 0; i--) {
    var currNum = nums[i];

    while (!stack.isEmpty() && currNum <= nums[stack.peek()])
      stack.pop();

    ans[i] = stack.isEmpty() ? n : stack.peek();
    stack.push(i);
  }

  return ans;
}

}