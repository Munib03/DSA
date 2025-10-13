class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        rec(0, target, 0, candidates, new ArrayList<>());
        return ans;
    }

    private void rec(int index, int target, int sum, int[] nums, List<Integer> list) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (index >= nums.length || sum > target)
            return;

        list.add(nums[index]);
        rec(index + 1, target, sum + nums[index], nums, list);
        list.removeLast();

        int next = index + 1;
        while (next < nums.length && nums[next] == nums[index])
            next++;

        rec(next, target, sum, nums, list);
    }
}
