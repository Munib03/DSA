class Solution {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();

        for (var ch : s.toCharArray()) {
            switch (ch) {
                case '(', '{', '[' -> stack.push(ch);

                default -> {
                    if (stack.isEmpty())
                        return false;

                    var top = stack.pop();
                    if ((top == '(' && ch != ')') || (top == '{' && ch != '}') || (top == '[' && ch != ']'))
                        return false;
                }
            }
        }

        return stack.isEmpty();
    }
}