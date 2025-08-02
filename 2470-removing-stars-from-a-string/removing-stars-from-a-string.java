class Solution {
    public String removeStars(String s) {
        var stack = new Stack<Character>();

        for (var ch : s.toCharArray()) {
            if (ch == '*')
                stack.pop();
            else
                stack.push(ch);
        }

        var sb = new StringBuilder();
        for (var sth : stack)
            sb.append(sth);

        return sb.toString();
    }
}