class Solution {
    public List<Integer> partitionLabels(String s) {
        var n = s.length();
        var map = addToMap(s);

        var list = new ArrayList<Integer>();

        var startIndex = 0;
        var lastCharIndex = 0;

        for (var i = 0; i < n; i++) {
            var me = s.charAt(i);
            var get = map.get(me);

            if (get > lastCharIndex)
                lastCharIndex = get;

            if (i == lastCharIndex) {
                var size = lastCharIndex - startIndex + 1;
                list.add(size);
                startIndex = lastCharIndex + 1;
            }
        }

        return list;
    }

    private HashMap<Character, Integer> addToMap(String s) {
        var map = new HashMap<Character, Integer>();

        for (var i = 0; i < s.length(); i++)
            map.put(s.charAt(i), i);

        return map;
    }

}