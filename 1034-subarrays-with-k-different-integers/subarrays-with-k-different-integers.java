class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        var ans1 = finder(nums, k);
        var ans2 = finder(nums, k - 1);

        return ans1 - ans2;
    }

    private int finder(int[] nums, int k) {
        if (k < 0)
            return 0;

        var n = nums.length;

        var cnt = 0;
        var map = new HashMap<Integer, Integer>();

        var left = 0;
        var right = 0;

        while (right < n) {
            var ou = nums[right];

            map.put(ou, map.getOrDefault(ou, 0) + 1);
            while (map.size() > k) {
                var me = nums[left];
                map.put(me, map.get(me) - 1);

                if (map.get(me) == 0)
                    map.remove(me);

                left++;
            }

            if (map.size() <= k)
                cnt += right - left;

            right++;
        }

        return cnt;
    }
}