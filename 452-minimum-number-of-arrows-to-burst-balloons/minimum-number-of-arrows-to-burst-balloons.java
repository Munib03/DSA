class Solution {
    public int findMinArrowShots(int[][] points) {
        var n = points.length;

        Arrays.sort(points, Comparator.comparingInt(key -> key[1]));

        var cnt = 1;
        var endFirst = points[0][1];

        for (var i = 1; i < n; i++) {
            var startSecond = points[i][0];

            if (startSecond > endFirst) {
                cnt++;
                endFirst = points[i][1];
            }
        }

        return cnt;
    }

}