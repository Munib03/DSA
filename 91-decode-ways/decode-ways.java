class Solution {
    public int numDecodings(String s) {
        return dfs(0, s, new HashMap<>());
    }

    private int dfs(int index, String s, Map<Integer, Integer> map) {
        if (index == s.length())
            return 1;

        else if (s.charAt(index) == '0')
            return 0;

        else if (map.containsKey(index))
            return map.get(index);

        var ways = 0;
        ways += dfs(index + 1, s, map);

        if (index + 1 < s.length()) {
            var twoDigit = Integer.parseInt(s.substring(index, index + 2));

            if (twoDigit >= 10 && twoDigit <= 26)
                ways += dfs(index + 2, s, map);
        }

        map.put(index, ways);
        return ways;
    }

}