class Solution {
    public int countPalindromicSubsequence(String s) {
        var cnt = 0;

        var map = new HashMap<Character, Integer>();
        for (var ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        var set = new HashSet<Character>();
        var seen = new HashSet<String>();

        for (var ch : s.toCharArray()) {
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0)
                map.remove(ch);

            for (var sth : set) {
                if (map.containsKey(sth)) {
                    var key = sth + "|" + ch;
                    if (!seen.contains(key)) {
                        seen.add(key);
                        cnt++;
                    }
                }
            }

            set.add(ch);
        }

        return cnt;
    }

}