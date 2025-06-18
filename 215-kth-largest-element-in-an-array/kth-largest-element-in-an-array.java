class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;

        var pq = new PriorityQueue<Integer>();
        for (int num : nums)
            pq.offer(num);

        for (int i = 0; i < k; i++)
            pq.poll();

        return pq.peek();
    }
}
