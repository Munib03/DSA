class Solution {
    public String removeDuplicates(String s) {
        var stack = new Stack<Character>();

        for (var ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch)
                stack.pop();
            else
                stack.push(ch);
        }

        var sb = new StringBuilder();
        for (var ch : stack)
            sb.append(ch);

        return sb.toString();
    }
}