class Solution {
    public int minTimeToVisitAllPoints(int[][] p) {
        var ans = 0;
        for (var i = 1; i < p.length; i++) {
            ans += Math.max(
                    Math.abs(p[i][0] - p[i - 1][0]),
                    Math.abs(p[i][1] - p[i - 1][1]));
        }

        return ans;
    }
}