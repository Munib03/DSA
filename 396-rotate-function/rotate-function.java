class Solution {
public int maxRotateFunction(int[] nums) {
  var f = 0;
  var n = nums.length;
  
  var  numSum = Arrays.stream(nums).sum();
  
  for (var i = 0; i < n; i++) 
    f += i * nums[i];
  
  var res = f;
  for (var i = n - 1; i > 0; i--) {
    f += numSum - n * nums[i];
    res = Math.max(res, f);
  }
  
  return res;
}
}