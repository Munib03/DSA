class Solution {
    public int[] nextGreaterElements(int[] nums) {
        var n = nums.length;
        int[] ans = new int[n];

        var monotonicStack = new Stack<Integer>();

        for (var i = n - 1; i >= 0; i--) {
            var curr = nums[i];

            if (monotonicStack.isEmpty())
                monotonicStack.push(curr);
            else {
                while (!monotonicStack.isEmpty() && monotonicStack.peek() <= curr)
                    monotonicStack.pop();

                monotonicStack.push(curr);
            }
        }

        for (var i = n - 1; i >= 0; i--) {
            var curr = nums[i];

            while (!monotonicStack.isEmpty() && monotonicStack.peek() <= curr)
                monotonicStack.pop();

            if (monotonicStack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = monotonicStack.peek();

            monotonicStack.push(curr);
        }

        return ans;
    }
}