class Solution {
    public long maxKelements(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (var num : nums)
            pq.offer(num);

        long score = 0;
        while (k-- > 0) {
            var peak = pq.remove();

            score += peak;
            pq.offer((int) Math.ceil((double) peak / 3));
        }

        return score;
    }
}