class Solution {
    public int minLength(String s) {
        var stack = new Stack<Character>();

        for (var i = 0; i < s.length(); i++) {
            var curr = s.charAt(i);

            if (stack.isEmpty())
                stack.push(curr);
            else {
                var pair = stack.peek() + "" + curr;

                if (pair.equals("AB") || pair.equals("CD"))
                    stack.pop();
                else
                    stack.push(curr);
            }
        }

        return stack.size();
    }
}