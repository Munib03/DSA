class Solution {
public void wiggleSort(int[] nums) {
  var n = nums.length;
  Arrays.sort(nums);

  var index = 1;
  int[] ansArr = new int[n];

  var i = n-1;
  for (i=n-1; i >= 0 && index < n; i--, index += 2)
    ansArr[index] = nums[i];

  index = 0;
  for (; i >= 0; i--, index += 2)
    ansArr[index] = nums[i];

  System.arraycopy(ansArr, 0, nums, 0, n);
}
}