class Solution {
    public String removeKdigits(String num, int k) {
        var n = num.length();
        if (k >= n)
            return "0";

        var stack = new Stack<Character>();

        for (var i = 0; i < n; i++) {
            var currChar = num.charAt(i);

            while (k > 0 && !stack.isEmpty() && currChar < stack.peek()) {
                stack.pop();
                k--;
            }

            stack.push(currChar);
        }

        while (k-- > 0)
            stack.pop();

        var sb = new StringBuilder();
        for (Character character : stack) {
            if (character == '0' && sb.isEmpty())
                continue;

            sb.append(character);
        }

        if (sb.isEmpty())
            return "0";

        return sb.toString();
    }
}