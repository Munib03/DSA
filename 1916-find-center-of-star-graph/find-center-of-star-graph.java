class Solution {
    public int findCenter(int[][] edges) {
        var first = edges[0][0];
        var second = edges[0][1];

        var currFirst = edges[1][0];
        var currSecond = edges[1][1];

        if (currFirst == first || currSecond == first)
            return first;

        return second;
    }
}