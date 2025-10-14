class Solution {
    private final List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(0, target, 0, candidates, new ArrayList<>());

        return ansList;
    }

    private void backtrack(int index, int target, int sum, int[] nums, List<Integer> list) {
        if (index >= nums.length || sum > target)
            return;

        else if (sum == target) {
            ansList.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        sum += nums[index];
        backtrack(index, target, sum, nums, list);

        list.removeLast();
        sum -= nums[index];
        backtrack(index + 1, target, sum, nums, list);
    }

}