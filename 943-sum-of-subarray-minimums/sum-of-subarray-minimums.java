class Solution {
    public int sumSubarrayMins(int[] arr) {
        var n = arr.length;
        var mod = (int) 1e9 + 7;

        var nse = nextSmallerElement(arr);
        var pse = previousSmallerElement(arr);

        var totalAns = 0;

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            long prod = ((long) left * right) % mod;
            prod = (prod * arr[i]) % mod;
            totalAns = (int) ((totalAns + prod) % mod);
        }

        return totalAns;
    }

    public int[] nextSmallerElement(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = n - 1; i >= 0; i--) {
            var currNum = nums[i];

            while (!monotonicStack.isEmpty() && currNum <= nums[monotonicStack.peek()])
                monotonicStack.pop();

            if (monotonicStack.isEmpty())
                ans[i] = n;
            else
                ans[i] = monotonicStack.peek();

            monotonicStack.push(i);
        }

        return ans;
    }

    public int[] previousSmallerElement(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = 0; i < n; i++) {
            var currNum = nums[i];

            while (!monotonicStack.isEmpty() && currNum < nums[monotonicStack.peek()])
                monotonicStack.pop();

            if (monotonicStack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = monotonicStack.peek();

            monotonicStack.push(i);
        }

        return ans;
    }
}