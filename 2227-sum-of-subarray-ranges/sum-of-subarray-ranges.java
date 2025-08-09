class Solution {
    public long subArrayRanges(int[] nums) {
        var ssmins = sumSubarrayMins(nums);
        var ssmaxes = sumSubarrayMaxes(nums);

        return ssmaxes - ssmins;
    }

    public long sumSubarrayMins(int[] arr) {
        var n = arr.length;

        var pse = previousSmallerElementIndexes(arr);
        var nse = nextSmallerElementIndexes(arr);

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
        var nse = nextGreaterElementIndexes(arr);

        var sum = 0L;

        for (var i = 0; i < n; i++) {
            var left = i - pse[i];
            var right = nse[i] - i;

            long prod = ((long) left * right) * arr[i];
            sum += prod;
        }

        return sum;
    }

    public int[] nextGreaterElementIndexes(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = n - 1; i >= 0; i--) {
            var num = nums[i];

            // [1, 2, 3, 2, 5]
            while (!monotonicStack.isEmpty() && num > nums[monotonicStack.peek()])
                monotonicStack.pop();

            ans[i] = (monotonicStack.isEmpty()) ? n : monotonicStack.peek();
            monotonicStack.push(i);
        }

        return ans;
    }

    public int[] previousGreaterElement(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = 0; i < n; i++) {
            var num = nums[i];

            while (!monotonicStack.isEmpty() && num >= nums[monotonicStack.peek()])
                monotonicStack.pop();

            ans[i] = (monotonicStack.isEmpty()) ? -1 : monotonicStack.peek();
            monotonicStack.push(i);
        }

        return ans;
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