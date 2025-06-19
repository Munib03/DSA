class Solution {
    public long pickGifts(int[] gifts, int k) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (var num : gifts)
            pq.offer(num);

        var cnt = 0;

        while (cnt < k) {
            var now = (int) Math.floor(Math.sqrt(pq.remove()));
            pq.offer(now);

            cnt++;
        }

        var total = 0L;
        for (var num : pq)
            total += num;

        return total;
    }
}