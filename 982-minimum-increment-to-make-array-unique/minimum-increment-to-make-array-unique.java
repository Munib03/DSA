class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        var cnt = 0;
        var visited = new HashSet<Integer>();
        var max = 0;

        for (var i = 0; i < nums.length; i++) {
            var now = nums[i];

            if (visited.contains(now)) {
                var diff = Math.abs((max + 1) - now);
                now = max + 1;

                cnt += diff;
                max = Math.max(now, max);
            }

            max = Math.max(max, now);
            visited.add(now);
        }

        return cnt;
    }
}