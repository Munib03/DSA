class Solution {
    public int maxUniqueSplit(String s) {
        backtrack(0, s, s, new ArrayList<>());

        return max;
    }

    private int max = 0;

    private void backtrack(int index, String theRealS, String s, List<String> list) {
        if (index >= theRealS.length()) {
            max = Integer.max(max, list.size());
            return;
        }

        for (var i = 0; i < s.length(); i++) {
            var str = s.substring(0, i + 1);
            if (list.contains(str))
                continue;

            list.add(str);
            var remainString = s.substring(i + 1);
            backtrack(i + 1, s, remainString, list);

            list.removeLast();
        }
    }
}