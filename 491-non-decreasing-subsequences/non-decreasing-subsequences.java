class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ansList = new HashSet<>();

        backtrack(0, nums, new ArrayList<>(), ansList);

        List<List<Integer>> theRealAns = new ArrayList<>();
        for (var sth : ansList) {
            var flag = true;

            if (sth.size() >= 2) {
                for (var i = 1; i < sth.size(); i++) {
                    var me = sth.get(i - 1);
                    var ou = sth.get(i);

                    if (ou < me) {
                        flag = false;
                        break;
                    }
                }

                if (flag)
                    theRealAns.add(sth);
            }
        }

        return theRealAns;
    }

    public void backtrack(int index, int[] nums, List<Integer> list, Set<List<Integer>> ansList) {
        if (index == nums.length) {
            ansList.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        backtrack(index + 1, nums, list, ansList);

        list.removeLast();
        backtrack(index + 1, nums, list, ansList);
    }
}