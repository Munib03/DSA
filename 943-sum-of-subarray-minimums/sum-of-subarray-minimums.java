class Solution {
    public int sumSubarrayMins(int[] arr) {
        var n = arr.length;
        var sum = 0;

        var mod = (int) 1e9 + 7;
        var pse = previousSmallerElement(arr);
        var nse = nextSmallerElement(arr);

        for (var i = 0; i < n; i++) {
            var left = i - pse[i];
            var right = nse[i] - i;

            long prod = ((long) left * right) % mod;
            prod = (prod * arr[i]) % mod;
            sum = (int) ((sum + prod) % mod);
        }

        return sum;
    }

    private int[] nextSmallerElement(int[] nums) {
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

    private int[] previousSmallerElement(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var stack = new Stack<Integer>();

        for (var i = 0; i < n; i++) {
            var currNum = nums[i];

            while (!stack.isEmpty() && currNum < nums[stack.peek()])
                stack.pop();

            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ans;
    }

}