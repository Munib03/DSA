class Solution {
    public int longestPalindromeSubseq(String s) {
        var sb = new StringBuilder();
        sb.append(s);
        sb.reverse();

        return matchNotMatch(0, 0, s, sb.toString(), new HashMap<>());
    }

    private int matchNotMatch(int i, int j, String s, String t, Map<String, Integer> map) {
        if (i == s.length() || j == t.length())
            return 0;

        var key = i + ", " + j;
        if (map.containsKey(key))
            return map.get(key);

        else if (s.charAt(i) == t.charAt(j))
            return 1 + matchNotMatch(i + 1, j + 1, s, t, map);

        var max = Math.max(
                matchNotMatch(i + 1, j, s, t, map),
                matchNotMatch(i, j + 1, s, t, map));

        map.put(key, max);
        return map.get(key);
    }

}