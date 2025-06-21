class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        var map = addToMap(words);
        var sortedMap = sortMapByValue(map);

        var list = new ArrayList<String>();
        for (var val : sortedMap.keySet()) {
            list.add(val);
            if (--k == 0)
                break;
        }

        return list;
    }

    private HashMap<String, Integer> addToMap(String[] words) {
        var map = new HashMap<String, Integer>();
        for (var word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        return map;
    }

    public LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
        var list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            int cmp = b.getValue().compareTo(a.getValue());
            if (cmp == 0)
                return a.getKey().compareTo(b.getKey());
            return cmp;
        });

        var sortedMap = new LinkedHashMap<String, Integer>();
        for (var entry : list)
            sortedMap.put(entry.getKey(), entry.getValue());

        return sortedMap;
    }

}