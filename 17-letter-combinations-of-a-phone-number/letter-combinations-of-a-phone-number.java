class Solution {
    public List<String> letterCombinations(String digits) {
        var map = new HashMap<Integer, String>();

        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        var res = new ArrayList<String>();
        backtrack(0, digits, map, res, new StringBuilder());

        return res;
    }

    private void backtrack(int index, String digits, Map<Integer, String> map, List<String> res, StringBuilder sb) {
        if (index >= digits.length()) {
            res.add(sb.toString());
            return;
        }

        var currDigit = Integer.parseInt(digits.charAt(index) + "");
        var letters = map.get(currDigit);

        for (var letter : letters.toCharArray()) {
            sb.append(letter);

            backtrack(index + 1, digits, map, res, sb);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}