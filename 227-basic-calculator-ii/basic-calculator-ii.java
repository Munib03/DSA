class Solution {
    public int calculate(String s) {
        var sb = new StringBuilder();
        for (var ch : s.toCharArray())
            if (ch != ' ')
                sb.append(ch);

        s = sb.toString();

        var postfix = infixToPostfix(s).split(" ");

        var stack = new Stack<String>();

        for (var sth : postfix) {
            if (Character.isDigit(sth.charAt(0)))
                stack.push(sth);

            else {
                var top1 = Integer.parseInt(stack.pop());
                var top2 = Integer.parseInt(stack.pop());

                var exp = 0;
                switch (sth.charAt(0)) {
                    case '+' -> exp = top2 + top1;
                    case '-' -> exp = top2 - top1;
                    case '*' -> exp = top2 * top1;
                    case '/' -> exp = top2 / top1;
                }

                stack.push(exp + "");
            }
        }

        return Integer.parseInt(stack.peek());
    }

    public String infixToPostfix(String s) {
        var n = s.length();

        var ans = new StringBuilder();
        var stack = new Stack<Character>();

        var i = 0;
        while (i < n) {
            var curr = s.charAt(i);

            var temp = new StringBuilder();
            var j = i;
            var flag = false;

            while (j < n && Character.isLetterOrDigit(s.charAt(j))) {
                temp.append(s.charAt(j));
                j++;
                i++;
                flag = true;
            }

            if (!temp.isEmpty() && (temp.length() > 1 || Character.isDigit(temp.charAt(0))))
                ans.append(temp).append(" ");

            else if (curr == '(')
                stack.push(curr);

            else if (curr == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    ans.append(stack.pop()).append(" ");

                stack.pop();
            }

            else {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(curr))
                    ans.append(stack.pop()).append(" ");

                stack.push(curr);
            }

            if (!flag)
                i++;
        }

        while (!stack.isEmpty())
            ans.append(stack.pop()).append(" ");

        return ans.toString();
    }

    public int getPriority(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }
}