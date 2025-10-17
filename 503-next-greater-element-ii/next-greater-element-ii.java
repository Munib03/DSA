class Solution {
    public int[] nextGreaterElements(int[] nums) {
        var n = nums.length;

        int[] ans = new int[2 * n];
        for (var i = 0; i < 2 * n; i++)
            ans[i] = nums[i % n];

        var stack = new Stack<Integer>();
        int[] theAns = new int[2 * n];

        for (var i = 2 * n - 1; i >= 0; i--) {
            var currNum = ans[i];

            while (!stack.isEmpty() && currNum >= stack.peek())
                stack.pop();

            theAns[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(currNum);
        }

        return Arrays.copyOf(theAns, n);
    }
}