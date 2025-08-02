class Solution {
    public String reverseParentheses(String s) {
        var stack = new Stack<Character>();

        for (var ch : s.toCharArray()) {
            if (ch == ')') {
                var sb = new StringBuilder();

                while (!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop());

                stack.pop();
                for (var ch1 : sb.toString().toCharArray())
                    stack.push(ch1);
            } else
                stack.push(ch);
        }

        var sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.reverse().toString();
    }
}