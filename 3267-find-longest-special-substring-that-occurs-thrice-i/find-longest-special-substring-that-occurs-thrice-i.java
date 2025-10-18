class Solution {
    public int maximumLength(String s) {
        var n = s.length();

        var map = new HashMap<String, Integer>();

        for (var i = 0; i < n; i++) {
            var sb = new StringBuilder();

            for (var j = i; j < n; j++) {
                sb.append(s.charAt(j));

                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            }
        }

        var maxLen = -1;

        for (var entry : map.entrySet()) {
            var key = entry.getKey();
            var set = new HashSet<Character>();
            for (var ch : key.toCharArray())
                set.add(ch);

            if (set.size() == 1) {
                var val = entry.getValue();

                if (val >= 3)
                    maxLen = Math.max(maxLen, key.length());
            }
        }

        return maxLen;
    }

}