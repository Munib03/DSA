class Solution {
    public int sumSubarrayMins(int[] arr) {
        var n = arr.length;

        var pse = previousSmallerElementIndexes(arr);
        var nse = nextSmallerElementIndexes(arr);

        var mod = (int) 1e9 + 7;
        var sum = 0;

        for (var i = 0; i < n; i++) {
            var left = i - pse[i];
            var right = nse[i] - i;

            long prod = ((long) left * right) % mod;
            prod = (prod * arr[i]) % mod;
            sum = (int) ((sum + prod) % mod);
        }

        return sum;
    }

    public int[] previousSmallerElementIndexes(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = 0; i < n; i++) {
            var num = nums[i];

            while (!monotonicStack.isEmpty() && num < nums[monotonicStack.peek()])
                monotonicStack.pop();

            ans[i] = (monotonicStack.isEmpty()) ? -1 : monotonicStack.peek();
            monotonicStack.push(i);
        }

        return ans;
    }

    public int[] nextSmallerElementIndexes(int[] nums) {
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