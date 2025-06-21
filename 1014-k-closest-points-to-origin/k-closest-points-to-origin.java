class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(
                        b[0] * b[0] + b[1] * b[1],
                        a[0] * a[0] + a[1] * a[1]));

        for (var point : points) {
            pq.offer(point);

            if (pq.size() > k)
                pq.poll();
        }

        var i = 0;
        int[][] ans = new int[k][2];
        while (k-- > 0) {
            ans[i++] = pq.poll();
        }

        return ans;
    }
}