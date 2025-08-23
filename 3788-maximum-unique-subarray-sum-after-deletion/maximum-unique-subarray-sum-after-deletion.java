class Solution {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        var set = new HashSet<Integer>();

        var sum = 0;
        for (var num: nums) {
            if (num > 0 && !set.contains(num))
                sum += num;

            set.add(num);
        }

        if (sum == 0)
            return nums[nums.length - 1];
            
        return sum;
    }
}