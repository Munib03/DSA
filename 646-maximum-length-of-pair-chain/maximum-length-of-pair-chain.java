class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(key -> key[1]));

        var cnt = 1;
        var b = pairs[0][1];

        for (var i = 1; i < pairs.length; i++) {
            var c = pairs[i][0];

            if (b < c) {
                b = pairs[i][1];
                cnt++;
            }
        }

        return cnt;
    }
}