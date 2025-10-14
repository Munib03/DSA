class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, target, 0, candidates, new ArrayList<>());

        return new ArrayList<>(ansList);
    }

    private final Set<List<Integer>> ansList = new HashSet<>();

    private void backtrack(int index, int target, int sum, int[] nums, List<Integer> list) {
        if (sum == target) {
            ansList.add(new ArrayList<>(list));
            return;
        }

        else if (index >= nums.length || sum > target)
            return;

        list.add(nums[index]);
        backtrack(index + 1, target, sum + nums[index], nums, list);

        list.removeLast();
        var nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index])
            nextIndex++;

        backtrack(nextIndex, target, sum, nums, list);
    }
}