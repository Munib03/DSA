class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        rec(0, candidates, target, new ArrayList<>());

        return new ArrayList<>(ansSet);
    }

    private final Set<List<Integer>> ansSet = new HashSet<>();

    private void rec(int index, int[] nums, int target, List<Integer> list) {
        if (index >= nums.length || target < 0)
            return;

        else if (target == 0) {
            var temp = new ArrayList<>(list);
            ansSet.add(temp);
            return;
        }

        list.add(nums[index]);
        rec(index, nums, target - nums[index], list);

        list.remove((Integer) nums[index]);
        rec(index + 1, nums, target, list);
    }
}