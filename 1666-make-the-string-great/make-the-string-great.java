class Solution {
    public String makeGood(String s) {
        var stack = new Stack<Character>();

        for (var ch : s.toCharArray()) {
            stack.push(ch);

            if (stack.size() > 1) {
                var top1 = stack.pop();
                var top2 = stack.pop();

                if (Character.toLowerCase(top1) == Character.toLowerCase(top2)) {
                    if (!(Character.isLowerCase(top1) && Character.isUpperCase(top2))
                            && !(Character.isUpperCase(top1) && Character.isLowerCase(top2))) {
                        stack.push(top2);
                        stack.push(top1);
                    }
                } else {
                    stack.push(top2);
                    stack.push(top1);
                }
            }
        }

        var sb = new StringBuilder();
        for (var ch : stack)
            sb.append(ch);

        return sb.toString();
    }
}