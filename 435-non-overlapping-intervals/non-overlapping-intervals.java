class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        var cnt = 0;
        var lastEnded = Integer.MIN_VALUE;

        for (var interval : intervals) {
            if (interval[0] >= lastEnded) {
                lastEnded = interval[1];
                cnt++;
            }
        }

        return intervals.length - cnt;
    }
}
