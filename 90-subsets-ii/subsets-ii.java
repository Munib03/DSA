class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        subset(0, nums, set, new ArrayList<>());

        return new ArrayList<>(set);
    }

    public void subset(int index, int[] nums, Set<List<Integer>> set, List<Integer> list) {
        if (index >= nums.length) {
            set.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        subset(index + 1, nums, set, list);

        list.removeLast();
        subset(index + 1, nums, set, list);
    }
}