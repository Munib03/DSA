class Solution {
// O(n log n) time, space O(1)
public List<List<Integer>> threeSum(int[] nums) {
  var n = nums.length;

  Arrays.sort(nums);
  Set<List<Integer>> ans = new HashSet<>();

  for (var i = 0; i < n; i++) {
    var currElement = nums[i];

    var left = i + 1;
    var right = n - 1;


    while (left < n && left < right) {
      var leftNum = nums[left];
      var rightNum = nums[right];

      var sum = currElement + leftNum + rightNum;
      if (sum == 0) {
        var list = new ArrayList<Integer>();
        list.add(currElement);
        list.add(leftNum);
        list.add(rightNum);

        ans.add(list);
        left++;
        right--;
      }
      else if (sum < 0)
        left++;

      else
        right--;
    }
  }

  return new ArrayList<>(ans);
}
}