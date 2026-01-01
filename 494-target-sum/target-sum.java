class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        var totalSum = 0;
        for (var num : nums)
            totalSum += num;

        return takeNotTake(0, 0, totalSum, target, nums, new HashMap<>());
    }

    private int takeNotTake(int index, int currSum, int totalSum, int target, int[] nums, Map<String, Integer> map) {
        if (index >= nums.length) {
            var tempSum = Math.abs(totalSum - currSum);
            if (currSum - tempSum == target)
                return 1;

            return 0;
        }

        var key = index + ", " + currSum;
        if (map.containsKey(key))
            return map.get(key);

        currSum += nums[index];
        var take = takeNotTake(index + 1, currSum, totalSum, target, nums, map);

        currSum -= nums[index];
        var notTake = takeNotTake(index + 1, currSum, totalSum, target, nums, map);

        var sum = take + notTake;
        map.put(key, sum);

        return sum;
    }

}