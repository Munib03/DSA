class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());

        return ansList;
    }

    private final List<List<Integer>> ansList = new ArrayList<>();

    private void backtrack(int index, int[] nums, List<Integer> list) {
        if (index >= nums.length) {
            ansList.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        backtrack(index + 1, nums, list);

        var nextIndex = index;
        while (nextIndex < nums.length && nums[index] == nums[nextIndex])
            nextIndex++;

        list.removeLast();
        backtrack(nextIndex, nums, list);
    }
}