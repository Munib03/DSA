class Solution {
    public int minDeletion(String s, int k) {
        var map = frequencyMap(s);
        var n = map.size();

        if (n <= k)
            return 0;

        var cnt = 0;
        var diff = n - k;
        for (var val : map.values()) {
            cnt += val;
            diff--;

            if (diff <= 0)
                break;
        }

        return cnt;
    }

    private Map<Character, Integer> frequencyMap(String str) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : str.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}