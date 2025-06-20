class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        var pq = new PriorityQueue<Integer>();

        for (var num : nums)
            pq.offer(num);

        while (k-- > 0) {
            var min = pq.remove();

            for (var i = 0; i < nums.length; i++) {
                if (nums[i] == min) {
                    pq.offer(nums[i] * multiplier);
                    nums[i] = nums[i] * multiplier;
                    break;
                }
            }
        }

        return nums;
    }
}