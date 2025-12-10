class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        backtrack(0, nums, new ArrayList<>(), ans);

        return new ArrayList<>(ans);
    }

    private void backtrack(int index, int[] nums, List<Integer> list, Set<List<Integer>> ansList) {
        if (index == nums.length) {
            ansList.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        backtrack(index + 1, nums, list, ansList);

        var nextIndex = index;
        while (nextIndex < nums.length && nums[index] == nums[nextIndex])
            nextIndex++;

        list.removeLast();
        backtrack(nextIndex, nums, list, ansList);
    }

}