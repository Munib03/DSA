class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        var map = new HashMap<String, Integer>();

        for (var word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        var pq = new PriorityQueue<String>((a, b) -> {
            var freqCompare = map.get(a) - map.get(b);

            if (freqCompare == 0)
                return b.compareTo(a);

            return freqCompare;
        });

        for (var word : map.keySet()) {
            pq.offer(word);

            if (pq.size() > k)
                pq.poll();
        }

        var list = new ArrayList<String>();
        while (!pq.isEmpty())
            list.add(pq.remove());

        Collections.reverse(list);

        return list;
    }
}