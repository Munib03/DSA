class Solution {
    public int numberOfSubstrings(String s) {
        var n = s.length();

        var map = new HashMap<Character, Integer>();
        var cnt = 0;

        var left = 0;
        var right = 0;

        while (right < n) {
            var currChar = s.charAt(right);

            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
            while (map.size() == 3) {
                var me = s.charAt(left);

                map.put(me, map.get(me) - 1);
                if (map.get(me) == 0)
                    map.remove(me);

                cnt += n - right;
                left++;
            }

            right++;
        }

        return cnt;
    }
}