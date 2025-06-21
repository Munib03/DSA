class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        var pq = new PriorityQueue<Integer>();

        for (var nums : matrix) {
            for (var num : nums) {
                pq.offer(num);
            }
        }

        while (k-- > 1) {
            pq.poll();
        }

        return pq.element();
    }
}