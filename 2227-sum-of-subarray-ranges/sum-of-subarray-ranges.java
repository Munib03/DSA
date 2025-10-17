class Solution {
    public long subArrayRanges(int[] nums) {
        var ssmins = sumSubarrayMins(nums);
        var ssmaxes = sumSubarrayMaxes(nums);

        return ssmaxes - ssmins;
    }

    public long sumSubarrayMins(int[] arr) {
        var n = arr.length;

        var pse = previousSmallerElement(arr);
        var nse = nextSmallerElement(arr);

        var sum = 0L;

        for (var i = 0; i < n; i++) {
            var left = i - pse[i];
            var right = nse[i] - i;

            long prod = ((long) left * right) * arr[i];
            sum += prod;
        }

        return sum;
    }

    public long sumSubarrayMaxes(int[] arr) {
        var n = arr.length;

        var pse = previousGreaterElement(arr);
        var nse = nextGreaterElement(arr);

        var sum = 0L;

        for (var i = 0; i < n; i++) {
            var left = i - pse[i];
            var right = nse[i] - i;

            long prod = ((long) left * right) * arr[i];
            sum += prod;
        }

        return sum;
    }

    private int[] nextGreaterElement(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var stack = new Stack<Integer>();

        for (var i = n - 1; i >= 0; i--) {
            var currNum = nums[i];

            while (!stack.isEmpty() && currNum > nums[stack.peek()])
                stack.pop();

            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    private int[] previousGreaterElement(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var stack = new Stack<Integer>();

        for (var i = 0; i < n; i++) {
            var currNum = nums[i];

            while (!stack.isEmpty() && currNum >= nums[stack.peek()])
                stack.pop();

            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ans;
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