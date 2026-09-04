class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();

        permutation(nums, ansList, new ArrayList<>(), new HashSet<>());

        return ansList;
    }

    public void permutation(int[] nums, List<List<Integer>> ansList,
            List<Integer> list, Set<Integer> set) {
        if (list.size() == nums.length) {
            ansList.add(new ArrayList<>(list));
            return;
        }

        for (var i = 0; i < nums.length; i++) {
            var num = nums[i];

            if (set.contains(i))
                continue;

            set.add(i);
            list.add(num);

            permutation(nums, ansList, list, set);

            set.remove(i);
            list.removeLast();
        }
    }
}