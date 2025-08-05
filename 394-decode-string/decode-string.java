class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                strStack.push(curr);
                curr = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decoded = strStack.pop();
                int repeat = countStack.pop();
                for (int i = 0; i < repeat; i++)
                    decoded.append(curr);
                curr = decoded;
            } else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }

}