class Solution {
public int minCostClimbingStairs(int[] cost) {
  var ans1 = minClimbingStairs(0, cost, new HashMap<>());
  var ans2 = minClimbingStairs(1, cost, new HashMap<>());

  return Math.min(ans1, ans2);
}

private int minClimbingStairs(int index, int[] costs, Map<Integer, Integer> map) {
  if (index >= costs.length)
    return 0;

  else if (map.containsKey(index))
    return map.get(index);

  var oneStep = costs[index] + minClimbingStairs(index + 1, costs, map);
  var twoStep = costs[index] + minClimbingStairs(index + 2, costs, map);

  var min = Math.min(oneStep, twoStep);
  map.put(index, min);

  return min;
}
}