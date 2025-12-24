class Solution {
    public int rob(int[] nums) {
        pickNotPick(0, 0, nums, new HashMap<>());

        return maxProfit;
    }

    private int maxProfit = 0;

    private void pickNotPick(int index, int currSum, int[] nums, Map<String, Integer> memoMap) {
        var key = index + ", " + currSum;
        if (index >= nums.length) {
            maxProfit = Math.max(maxProfit, currSum);
            return;
        }

        else if (memoMap.containsKey(key))
            return;

        currSum += nums[index];
        pickNotPick(index + 2, currSum, nums, memoMap);

        currSum -= nums[index];
        pickNotPick(index + 1, currSum, nums, memoMap);

        memoMap.put(key, currSum);
    }

}