class Solution {
    public String removeKdigits(String num, int k) {
        var n = num.length();

        if (k >= n)
            return "0";

        var monotonicStack = new Stack<Integer>();

        var index = 0;
        while (k > 0 && index < n) {
            var currNum = Integer.parseInt(num.charAt(index) + "");

            if (monotonicStack.isEmpty())
                monotonicStack.push(currNum);

            else {
                while (k > 0 && !monotonicStack.isEmpty() && currNum < monotonicStack.peek()) {
                    monotonicStack.pop();
                    k--;
                }

                monotonicStack.push(currNum);
            }

            index++;
        }

        while (index < n) {
            monotonicStack.push(Integer.parseInt(num.charAt(index) + ""));
            index++;
        }

        while (k-- > 0)
            monotonicStack.pop();

        var sb = new StringBuilder();
        for (var sth : monotonicStack) {
            if (sth == 0 && sb.isEmpty())
                continue;

            sb.append(sth);
        }

        if (sb.isEmpty())
            sb.append("0");

        return sb.toString();
    }
}