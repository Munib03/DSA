class Solution {
    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();

        for (var token : tokens) {
            if (token.length() > 1 || Character.isDigit(token.charAt(0)))
                stack.push(Integer.parseInt(token));
            else {
                var top1 = stack.pop();
                var top2 = stack.pop();

                var ans = 0;
                switch (token) {
                    case "+" -> ans = top2 + top1;
                    case "-" -> ans = top2 - top1;
                    case "*" -> ans = top2 * top1;
                    case "/" -> ans = top2 / top1;
                }

                stack.push(ans);
            }
        }

        return stack.peek();
    }
}