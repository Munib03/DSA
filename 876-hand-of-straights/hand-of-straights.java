class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        var n = hand.length;

        if (n % groupSize != 0)
            return false;

        var count = new HashMap<Integer, Integer>();
        for (var num : hand)
            count.put(num, count.getOrDefault(num, 0) + 1);

        var minH = new PriorityQueue<>(count.keySet());

        while (!minH.isEmpty()) {
            var peak = minH.peek();

            for (int i = peak; i < peak + groupSize; i++) {
                if (!count.containsKey(i))
                    return false;

                count.put(i, count.get(i) - 1);

                if (count.get(i) == 0) {
                    if (i != minH.peek())
                        return false;

                    minH.poll();
                }
            }
        }

        return true;
    }
}