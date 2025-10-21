class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        var n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        var cnt = 0;
        var firstEnd = 0;

        for (var i = 0; i < n; i++) {
            var secondEnd = intervals[i][1];

            if (secondEnd > firstEnd) {
                cnt++;
                firstEnd = secondEnd;
            }
        }

        return cnt;
    }

}