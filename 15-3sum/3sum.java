class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var n = nums.length;
        var list = new ArrayList<List<Integer>>();

        for (var i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            var left = i + 1;
            var right = n - 1;

            while (left < right) {
                var sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}
