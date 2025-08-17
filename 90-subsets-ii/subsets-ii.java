class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] nums, int startIndex, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for (var i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1])
                continue;

            path.add(nums[i]);

            backtrack(nums, i + 1, path, res);
            path.removeLast();
        }
    }
}