class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);

        return new ArrayList<>(result);
    }

    private void backtrack(int[] nums, int startIndex, List<Integer> path, HashSet<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (var i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);

            backtrack(nums, i + 1, path, result);
            path.removeLast();
        }
    }
}