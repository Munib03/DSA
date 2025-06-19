class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (var num : nums)
            pq.offer(num);

        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < k; i++) {
            var num = pq.remove();

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        var index = 0;
        int[] ans = new int[k];
        for (int currNum : nums) {
            if (map.containsKey(currNum)) {
                var get = map.get(currNum);

                if (get > 0) {
                    ans[index++] = currNum;
                    map.put(currNum, get - 1);
                }
            }
        }

        return ans;
    }
}