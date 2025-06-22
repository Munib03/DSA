class Solution {
    public int minSetSize(int[] arr) {
        var n = arr.length;

        var map = new HashMap<Integer, Integer>();

        for (var num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);

        var pq = new PriorityQueue<Integer>((a, b) -> b - a);
        pq.addAll(map.values());

        var copy = 0;
        var cnt = 0;

        while (copy < n / 2) {
            copy += pq.remove();
            cnt++;
        }

        return cnt;
    }
}