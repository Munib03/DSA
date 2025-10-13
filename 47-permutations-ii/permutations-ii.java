class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        rec(nums, new ArrayList<>(), new HashSet<>());

        return new ArrayList<>(setAns);
    }

    private final Set<List<Integer>> setAns = new HashSet<>();

    private void rec(int[] nums, List<Integer> list, Set<Integer> set) {
        if (list.size() == nums.length) {
            setAns.add(new ArrayList<>(list));
            return;
        }

        for (var i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                set.add(i);
                list.add(nums[i]);

                rec(nums, list, set);

                list.removeLast();
                set.remove(i);
            }
        }
    }
}