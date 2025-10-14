class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        rec(0, nums, new ArrayList<>(), k);

        return cnt;
    }

    private int cnt = 0;

    private void rec(int index, int[] nums, List<Integer> list, int k) {
        if (index >= nums.length) {
            if (!list.isEmpty()) {
                var flag = false;

                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if (Math.abs(list.get(i) - list.get(j)) == k) {
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

            return;
        }

        list.add(nums[index]);
        rec(index + 1, nums, list, k);

        list.removeLast();
        rec(index + 1, nums, list, k);
    }
}