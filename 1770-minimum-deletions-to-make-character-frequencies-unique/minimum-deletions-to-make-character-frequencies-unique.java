class Solution {
    public int minDeletions(String s) {
        var map = sortByValueDesc(addToMap(s));

        var set = new HashSet<Integer>();
        var cnt = 0;

        for (var val : map.values()) {
            while (val > 0 && set.contains(val)) {
                cnt++;
                val--;
            }

            set.add(val);
        }

        return cnt;
    }

    private Map<Character, Integer> addToMap(String s) {
        var map = new HashMap<Character, Integer>();

        for (var ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        return map;
    }

    private Map<Character, Integer> sortByValueDesc(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}