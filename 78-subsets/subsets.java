class Solution {
    private List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        rec(nums, 0, new ArrayList<>());

        return ansList;
    }

    private void rec(int[] nums, int index, List<Integer> list) {
        if (index >= nums.length) {
            var temp = new ArrayList<>(list);
            ansList.add(temp);
            return;
        }

        list.add(nums[index]);
        rec(nums, index + 1, list);

        list.remove((Integer) nums[index]);
        rec(nums, index + 1, list);
    }

}