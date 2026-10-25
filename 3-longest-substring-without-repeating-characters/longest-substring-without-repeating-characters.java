class Solution {
public int lengthOfLongestSubstring(String s) {
  var n = s.length();
  var max = 0;

  var map = new HashMap<Character, Integer>();

  var l = 0;
  var r = 0;

  while (r < n) {
    var ou = s.charAt(r);
    map.put(ou, map.getOrDefault(ou, 0) + 1);

    while (map.getOrDefault(ou, 0) > 1) {
      var me = s.charAt(l);
      map.put(me, map.get(me) - 1);
      l++;
    }

    max = Math.max(max, r - l + 1);
    r++;
  }

  return max;
}
}