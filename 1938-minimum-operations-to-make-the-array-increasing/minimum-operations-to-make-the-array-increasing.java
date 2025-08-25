class Solution {
public int minOperations(int[] nums) {
  var n = nums.length;
  var cnt = 0;

  for (var i=1; i < n; i++) {
    var prev = nums[i - 1];
    var next = nums[i];

    if (next <= prev) {
      var diff = Math.abs(prev - next);
      diff++;
      cnt += diff;

      nums[i] = diff + nums[i];
    }
  }

  return cnt;
}
}