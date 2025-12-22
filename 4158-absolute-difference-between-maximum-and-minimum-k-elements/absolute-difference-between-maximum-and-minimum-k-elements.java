class Solution {
    public int absDifference(int[] nums, int k) {
        var pq1 = new PriorityQueue<Integer>();
        var pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (var num : nums) {
            pq1.offer(num);
            pq2.offer(num);
        }

        var sum1 = 0;
        var copy = k;
        while (k-- > 0 && !pq1.isEmpty())
            sum1 += pq1.poll();

        var sum2 = 0;
        while (copy-- > 0 && !pq2.isEmpty())
            sum2 += pq2.poll();

        return Math.abs(sum1 - sum2);
    }

}