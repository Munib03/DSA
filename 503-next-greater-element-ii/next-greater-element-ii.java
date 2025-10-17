class Solution {
    public int[] nextGreaterElements(int[] nums) {
        var n = nums.length;

        var stack = new Stack<Integer>();
        int[] theAns = new int[n];

        for (var i = 2 * n - 1; i >= 0; i--) {
            var currNum = nums[i % n];

            while (!stack.isEmpty() && currNum >= stack.peek())
                stack.pop();

            theAns[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(currNum);
        }

        return theAns;
    }
}