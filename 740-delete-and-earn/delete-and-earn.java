class Solution {
public int deleteAndEarn(int[] nums) {
  var max = Integer.MIN_VALUE;
  for (var num: nums)
    max = Math.max(max, num);

  int[] points = new int[max + 1];
  for (var num: nums)
    points[num] += num;

  var n = points.length;

  int[] dp = new int[n];
  Arrays.fill(dp, -1);

  return takeNotTake(0, points, dp);
}

private int takeNotTake(int index, int[] nums, int[] dp) {
  if (index >= nums.length)
    return 0;

  else if (dp[index] != -1)
    return dp[index];

  var take = nums[index] + takeNotTake(index + 2, nums, dp);
  var notTake = takeNotTake(index + 1, nums, dp);

  var max = Math.max(take, notTake);
  dp[index] = max;

  return dp[index];
}
}