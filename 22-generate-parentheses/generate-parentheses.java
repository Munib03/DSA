class Solution {
    public List<String> generateParenthesis(int n) {
        var res = new ArrayList<String>();

        backtrack(n, 0, 0, res, new ArrayList<>());

        return res;
    }

    private void backtrack(int n, int openingBracket, int closingBracket, List<String> res, List<Character> temp) {
        if (openingBracket == n && openingBracket == closingBracket) {
            var sb = new StringBuilder();

            for (var sth : temp)
                sb.append(sth);

            res.add(sb.toString());
            return;
        }

        if (openingBracket < n) {
            temp.add('(');

            backtrack(n, openingBracket + 1, closingBracket, res, temp);
            temp.removeLast();
        }

        if (openingBracket > closingBracket) {
            temp.add(')');

            backtrack(n, openingBracket, closingBracket + 1, res, temp);
            temp.removeLast();
        }
    }
}