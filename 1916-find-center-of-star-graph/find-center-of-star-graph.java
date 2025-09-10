class Solution {
    public int findCenter(int[][] edges) {
        var n = edges.length;

        var first = edges[0][0];
        var second = edges[0][1];

        var cnt1 = 0;
        var cnt2 = 0;

        for (var i = 1; i < n; i++) {
            var currFirst = edges[i][0];
            var currSecond = edges[i][0];

            if (currFirst == first || currSecond == first)
                cnt1++;

            else if (currFirst == second || currSecond == second)
                cnt2++;
        }

        if (cnt1 > cnt2)
            return first;

        return second;
    }
}