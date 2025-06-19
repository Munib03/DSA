class Solution {
    public int[] numberGame(int[] nums) {
        var n = nums.length;
        var pq = new PriorityQueue<Integer>();

        for (var num : nums)
            pq.offer(num);

        var i = 0;
        int[] ans = new int[n];
        while (!pq.isEmpty()) {
            var alice = pq.remove();
            var bob = pq.remove();

            ans[i++] = bob;
            ans[i++] = alice;
        }

        return ans;
    }

}