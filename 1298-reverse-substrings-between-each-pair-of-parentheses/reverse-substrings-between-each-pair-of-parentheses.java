class Solution {
    public String reverseParentheses(String s) {
        var stack = new Stack<Character>();

        for (var ch : s.toCharArray()) {
            if (ch == ')') {
                var sb = new StringBuilder();

                while (!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop());

                stack.pop();
                for (var i = 0; i < sb.length(); i++)
                    stack.push(sb.charAt(i));
            } else
                stack.push(ch);
        }

        var sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.reverse().toString();
    }
}