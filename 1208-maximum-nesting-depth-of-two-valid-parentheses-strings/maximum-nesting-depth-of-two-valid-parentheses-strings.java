class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        var n = seq.length();
        int[] ans = new int[n];
        var index = 0;

        var stack1 = new Stack<Character>();
        var stack2 = new Stack<Character>();

        for (var ch : seq.toCharArray()) {
            if (ch == '(') {
                if (stack1.isEmpty() || stack1.size() < stack2.size()) {
                    stack1.push(ch);
                    ans[index++] = 0;
                } else {
                    stack2.push(ch);
                    ans[index++] = 1;
                }
            } else if (ch == ')') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                    ans[index++] = 0;
                } else if (!stack2.isEmpty()) {
                    stack2.pop();
                    ans[index++] = 1;
                }
            }
        }

        return ans;
    }
}