class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        recursion(0, 0, nums, new ArrayList<>());

        return new ArrayList<>(ansSet);
    }

    private final Set<List<Integer>> ansSet = new HashSet<>();

    private void recursion(int index, int sum, int[] nums, List<Integer> list) {
        if (index >= nums.length) {
            ansSet.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        recursion(index + 1, sum + nums[index], nums, list);

        list.removeLast();
        recursion(index + 1, sum, nums, list);
    }
}