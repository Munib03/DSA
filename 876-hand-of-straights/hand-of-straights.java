class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        var n = hand.length;

        if (n % groupSize != 0)
            return false;

        var map = new HashMap<Integer, Integer>();
        for (var num : hand)
            map.put(num, map.getOrDefault(num, 0) + 1);

        var minHeap = new PriorityQueue<>(map.keySet());

        while (!minHeap.isEmpty()) {
            var peak = minHeap.peek();

            for (int i = peak; i < groupSize + peak; i++) {
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