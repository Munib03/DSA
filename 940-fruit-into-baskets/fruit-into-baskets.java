class Solution {
public int totalFruit(int[] fruits) {
  var n = fruits.length;

  var map = new HashMap<Integer, Integer>();
  var maxLen = 0;

  var left = 0;
  var right = 0;

  while (right < n) {
    var fruit = fruits[right];

    map.put(fruit, map.getOrDefault(fruit, 0) + 1);

    while (map.size() > 2) {
      var me = fruits[left];
      map.put(me, map.get(me) - 1);

      if (map.get(me) == 0)
        map.remove(me);

      left++;
    }

    maxLen = Math.max(maxLen, right - left + 1);
    right++;
  }

  return maxLen;
}
}