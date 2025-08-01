class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var n = temperatures.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = n - 1; i >= 0; i--) {
            var currNum = temperatures[i];

            while (!monotonicStack.isEmpty() && currNum >= temperatures[monotonicStack.peek()])
                monotonicStack.pop();

            if (monotonicStack.isEmpty())
                ans[i] = 0;
            else
                ans[i] = monotonicStack.peek() - i;

            monotonicStack.push(i);
        }

        return ans;
    }
}