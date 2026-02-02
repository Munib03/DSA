class Solution {
public int rob(int[] nums) {
  var n = nums.length;

  int[] dp = new int[n + 1];
  Arrays.fill(dp, -1);

  return takeNotTake(0, nums, dp);
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