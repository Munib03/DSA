class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        var n = intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(key -> key[1]));

        var cnt = 0;
        var endFirst = intervals[0][1];

        for (var i = 1; i < n; i++) {
            var startFirst = intervals[i][0];

            if (endFirst > startFirst)
                cnt++;

            else
                endFirst = intervals[i][1];
        }

        return cnt;
    }

}