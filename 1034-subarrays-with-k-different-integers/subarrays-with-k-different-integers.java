class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return numOfSubArrLessOrEquThanK(nums, k) - numOfSubArrLessOrEquThanK(nums, k - 1);
    }

    private int numOfSubArrLessOrEquThanK(int[] nums, int k) {
        var n = nums.length;
        var cnt = 0;

        var map = new HashMap<Integer, Integer>();
        var left = 0;
        var right = 0;

        while (right < n) {
            var num = nums[right];

            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.size() > k) {
                var me = nums[left];

                map.put(me, map.get(me) - 1);
                if (map.get(me) == 0)
                    map.remove(me);

                left++;
            }

            cnt += (right - left) + 1;
            right++;
        }

        return cnt;
    }
}