class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var n = nums.length;

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (var i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

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

                    while (left < right && nums[left] == nums[left - 1])
                        left++;

                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum < 0)
                    left++;

                else
                    right--;
            }
        }

        return ans;
    }
}