class Solution {
public boolean canJump(int[] nums) {
  var n = nums.length;

  var max = 0;

  for (var i=0; i < n; i++) {
    var num = nums[i];

    if (i == max && num == 0 && i != n - 1)
      return false;

    max = Math.max(max, i + num);
    if (max >= n - 1)
      return true;
  }

  return true;
}
}