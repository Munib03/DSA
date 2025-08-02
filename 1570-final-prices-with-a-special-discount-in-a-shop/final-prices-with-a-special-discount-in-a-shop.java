class Solution {
    public int[] finalPrices(int[] prices) {
        var n = prices.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = n - 1; i >= 0; i--) {
            var price = prices[i];

            while (!monotonicStack.isEmpty() && price < monotonicStack.peek())
                monotonicStack.pop();

            if (monotonicStack.isEmpty())
                ans[i] = price;
            else
                ans[i] = price - monotonicStack.peek();

            monotonicStack.push(price);
        }

        return ans;
    }
}