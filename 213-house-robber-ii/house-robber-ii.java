class Solution {
    public int rob(int[] nums) {
        var n = nums.length;
        if (n == 1)
            return nums[0];

        int[] nums1 = Arrays.copyOfRange(nums, 1, n);
        int[] nums2 = Arrays.copyOfRange(nums, 0, n - 1);

        var ans1 = takeOrNotTake(0, nums1, new HashMap<>());
        var ans2 = takeOrNotTake(0, nums2, new HashMap<>());

        return Math.max(ans1, ans2);
    }

    private int takeOrNotTake(int index, int[] nums, Map<Integer, Integer> map) {
        if (index >= nums.length)
            return 0;

        else if (map.containsKey(index))
            return map.get(index);

        var pick = nums[index] + takeOrNotTake(index + 2, nums, map);
        var notPick = takeOrNotTake(index + 1, nums, map);

        map.put(index, Math.max(pick, notPick));

        return Math.max(pick, notPick);
    }
}