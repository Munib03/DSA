class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        backtrack(nums, new HashSet<>(), new ArrayList<>(), ans);

        return new ArrayList<>(ans);
    }

    private void backtrack(int[] nums, Set<Integer> set, List<Integer> temp, Set<List<Integer>> list) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (var i = 0; i < nums.length; i++) {
            if (set.contains(i))
                continue;

            set.add(i);
            temp.add(nums[i]);
            backtrack(nums, set, temp, list);

            set.remove(i);
            temp.removeLast();
        }

    }
}