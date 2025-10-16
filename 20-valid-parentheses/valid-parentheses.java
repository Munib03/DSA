class Solution {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();

        for (var ch : s.toCharArray()) {
            switch (ch) {
                case '[', '(', '{' -> stack.push(ch);
                default -> {
                    if (stack.isEmpty())
                        return false;

                    var topOfStack = stack.pop();

                    if ((topOfStack == '[' && ch != ']') || (topOfStack == '(' && ch != ')')
                            || (topOfStack == '{' && ch != '}'))
                        return false;
                }
            }
        }

        return stack.isEmpty();
    }
}