class Solution {
public int lengthOfLIS(int[] nums) {
  var n = nums.length;

  int[][] dp = new int[n + 1][n + 1];
  for (var sth : dp)
    Arrays.fill(sth, -1);

  var prev = -1;

  return takeNotTake(0, prev, nums, dp);
}

private int takeNotTake(int index, int prev, int[] nums, int[][] dp) {
  if (index == nums.length)
    return 0;

  else if (dp[index][prev + 1] != -1)
    return dp[index][prev + 1];

  var skip = takeNotTake(index + 1, prev, nums, dp);

  var take = 0;
  if (prev == -1 || nums[index] > nums[prev])
    take = 1 + takeNotTake(index + 1, index, nums, dp);

  var max = Math.max(skip, take);
  dp[index][prev + 1] = max;

  return dp[index][prev + 1];
}

}