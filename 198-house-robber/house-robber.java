class Solution {
    public int rob(int[] nums) {
        var n = nums.length;

        return rec(n - 1, nums, new HashMap<>());
    }

    private int rec(int index, int[] nums, Map<Integer, Integer> map) {
        if (index < 0)
            return 0;

        else if (index == 0)
            return nums[index];

        if (map.containsKey(index))
            return map.get(index);

        var pick = nums[index] + rec(index - 2, nums, map);
        var noPick = rec(index - 1, nums, map);

        map.put(index, Math.max(pick, noPick));

        return Math.max(pick, noPick);
    }
}