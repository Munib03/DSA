class Solution {
    public String removeKdigits(String num, int k) {
        var n = num.length();

        if (k >= n)
            return "0";

        var stack = new Stack<Character>();

        var index = 0;
        while (index < n) {
            while (!stack.isEmpty() && k > 0 && (stack.peek() - '0') > (num.charAt(index) - '0')) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(index));
            index++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty())
            return "0";

        var res = new StringBuilder();
        for (var sth : stack) {
            if (res.isEmpty() && sth == '0')
                continue;

            res.append(sth);
        }

        if (res.isEmpty())
            return "0";

        return res.toString();
    }
}