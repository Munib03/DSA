class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        var n = nums.length;

        if (n % k != 0)
            return false;

        var map = new HashMap<Integer, Integer>();
        for (var num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        var minHeap = new PriorityQueue<>(map.keySet());

        while (!minHeap.isEmpty()) {
            var top = minHeap.peek();

            for (int i = top; i < k + top; i++) {
                if (!map.containsKey(i))
                    return false;

                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    if (i != minHeap.peek())
                        return false;

                    minHeap.poll();
                }
            }
        }

        return true;
    }
}