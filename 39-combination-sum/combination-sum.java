class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        rec(0, 0, target, candidates, new ArrayList<>());

        return new ArrayList<>(ansSet);
    }

    private final Set<List<Integer>> ansSet = new HashSet<>();

    private void rec(int index, int sum, int target, int[] nums, List<Integer> list) {
        if (index >= nums.length || sum > target)
            return;

        if (sum == target) {
            var temp = new ArrayList<>(list);
            ansSet.add(temp);

            return;
        }

        list.add(nums[index]);
        rec(index, sum + nums[index], target, nums, list);

        list.remove((Integer) nums[index]);
        rec(index + 1, sum, target, nums, list);
    }
}