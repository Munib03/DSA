class Solution {

    public int characterReplacement(String s, int k) {
        var n = s.length();

        var maxLen = 0;
        var maxSoFar = 0;
        var map = new HashMap<Character, Integer>();

        var left = 0;
        var right = 0;

        while (right < n) {
            var currChar = s.charAt(right);

            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
            maxSoFar = Math.max(maxSoFar, map.get(currChar));

            if (((right - left + 1) - maxSoFar) > k) {
                while (((right - left + 1) - maxSoFar) > k) {
                    var me = s.charAt(left);

                    map.put(me, map.get(me) - 1);
                    if (map.get(me) == 0)
                        map.remove(me);

                    maxSoFar = 0;
                    for (var val : map.values())
                        maxSoFar = Math.max(maxSoFar, val);

                    left++;
                }
            } else
                maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }

}