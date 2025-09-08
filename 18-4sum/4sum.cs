public class Solution {
    public IList<IList<int>> FourSum(int[] nums, int target) {
      var n = nums.Length;
      
      IList<IList<int>> ans = new List<IList<int>>();
      Array.Sort(nums);

      for (var i=0; i < n; i++) {
        if (i > 0 && nums[i] == nums[i - 1])
          continue;

        var iElement = nums[i];

        for (var j=i+1; j < n; j++) {
          if (j > (i + 1) && nums[j] == nums[j - 1])
            continue;

          var jElement = nums[j];
          var left = j + 1;
          var right = n - 1;

          while (left < right) {
            var leftNum = nums[left];
            var rightNum = nums[right];

            long sum = (long)iElement + jElement + leftNum + rightNum;
            if (sum == target) {
              var list = new List<int>();

              list.Add(iElement);
              list.Add(jElement);
              list.Add(leftNum);
              list.Add(rightNum);

              ans.Add(list);

              left++;
              right--;

              while (left < right && nums[left] == nums[left - 1])
                left++;

              while (left < right && nums[right] == nums[right + 1])
                right--;
            }

            else if (sum < target)
              left++;

            else
              right--;
          }
        }
      }

      return ans;
    }
}