class Solution {
public int coinChange(int[] coins, int amount) {
  if (amount == 0)
    return 0;

  int ans = takeNotTake(0, 0, amount, coins, new HashMap<>());
  return ans >= 1e9 ? -1 : ans;
}

private int takeNotTake(int index, int sum, int target,
                        int[] nums, Map<String, Integer> map) {

  if (sum == target)
    return 0;

  if (sum > target || index >= nums.length)
    return (int) 1e9;

  var key = index + "," + sum;
  if (map.containsKey(key))
    return map.get(key);

  var take = 1 + takeNotTake(index, sum + nums[index], target, nums, map);

  var notTake = takeNotTake(index + 1, sum, target, nums, map);

  var res = Math.min(take, notTake);
  map.put(key, res);

  return res;
}
}