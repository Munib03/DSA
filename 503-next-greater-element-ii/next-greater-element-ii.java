class Solution {
    public int[] nextGreaterElements(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = n - 1; i >= 0; i--) {
            var num = nums[i];

            while (!monotonicStack.isEmpty() && num >= monotonicStack.peek())
                monotonicStack.pop();

            monotonicStack.push(num);
        }

        for (var i = n - 1; i >= 0; i--) {
            var num = nums[i];

            while (!monotonicStack.isEmpty() && num >= monotonicStack.peek())
                monotonicStack.pop();

            if (monotonicStack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = monotonicStack.peek();

            monotonicStack.push(num);
        }

        return ans;
    }
}