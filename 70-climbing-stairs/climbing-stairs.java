class Solution {
public int climbStairs(int n) {
  return ans(n, new HashMap<>());
}

private int ans(int n, Map<Integer, Integer> map) {
  if (n <= 2)
    return n;

  else if (map.containsKey(n))
    return map.get(n);

  map.put(n, ans(n - 1, map) + ans(n - 2, map));

  return map.get(n);
}
}