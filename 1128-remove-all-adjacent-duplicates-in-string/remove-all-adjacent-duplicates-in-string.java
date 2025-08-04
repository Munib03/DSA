class Solution {
    public String removeDuplicates(String s) {
        var stack = new Stack<Character>();

        for (var ch : s.toCharArray()) {
            stack.push(ch);

            if (stack.size() >= 2) {
                var top1 = stack.pop();
                var top2 = stack.pop();

                if (top1 != top2) {
                    stack.push(top2);
                    stack.push(top1);
                }
            }
        }

        var sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.reverse().toString();
    }
}