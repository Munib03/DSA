class Solution {
    public int minAddToMakeValid(String s) {
        var stack = new Stack<Character>();
        var cnt = 0;

        for (var ch : s.toCharArray()) {
            if (ch == '(')
                stack.push(ch);

            else {
                if (stack.isEmpty())
                    cnt++;
                else
                    stack.pop();
            }
        }

        return cnt + stack.size();
    }
}