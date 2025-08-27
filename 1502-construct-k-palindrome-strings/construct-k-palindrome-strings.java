class Solution {
    public boolean canConstruct(String s, int k) {
        var n = s.length();

        if (k > n)
            return false;

        else if (k > 26 || k == n)
            return true;

        var map = addToMap(s);
        var oddCnt = 0;

        for (var val : map.values()) {
            if (val % 2 == 1)
                oddCnt++;

            if (oddCnt > k)
                return false;
        }

        return oddCnt <= k;
    }

    private HashMap<Character, Integer> addToMap(String s) {
        var map = new HashMap<Character, Integer>();

        for (var ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        return map;
    }

}