class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        rec(0, nums, new ArrayList<>());
        var cnt = 0;

        for (var list : ansList) {
            var flag = false;

            for (var i = 0; i < list.size(); i++) {
                var me = list.get(i);

                for (var j = 0; j < list.size(); j++) {
                    var ou = list.get(j);

                    var diff = Math.abs(me - ou);
                    if (diff == k) {
                        flag = true;
                        break;
                    }
                }

                if (flag)
                    break;
            }

            if (!flag)
                cnt++;

        }

        return cnt;
    }

    private final List<List<Integer>> ansList = new ArrayList<>();

    private void rec(int index, int[] nums, List<Integer> list) {
        if (index >= nums.length) {
            if (!list.isEmpty())
                ansList.add(new ArrayList<>(list));

            return;
        }

        list.add(nums[index]);
        rec(index + 1, nums, list);

        list.removeLast();
        rec(index + 1, nums, list);
    }
}