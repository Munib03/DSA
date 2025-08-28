class Solution {
    public int minDeletions(String s) {
        var map = addToMap(s);

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
}