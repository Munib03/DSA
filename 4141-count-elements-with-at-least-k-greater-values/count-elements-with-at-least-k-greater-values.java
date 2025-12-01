class Solution {
    public int countElements(int[] nums, int k) {
        var n = nums.length;
        var cnt = 0;

        Arrays.sort(nums);
        var lastIndexes = addToMap(nums);

        for (var num : nums) {
            var lastIndex = lastIndexes.get(num) + 1;

            var temp = n - lastIndex;
            if (temp >= k)
                cnt++;

        }

        return cnt;
    }

    private HashMap<Integer, Integer> addToMap(int[] nums) {
        var map = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        return map;
    }
}