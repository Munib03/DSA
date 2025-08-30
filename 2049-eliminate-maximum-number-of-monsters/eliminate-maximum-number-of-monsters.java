class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        var n = dist.length;

        double[] arrival = new double[n];
        for (var i = 0; i < n; i++)
            arrival[i] = (double) dist[i] / speed[i];

        var cnt = 0;
        Arrays.sort(arrival);

        for (var i = 0; i < n; i++) {
            if (arrival[i] <= i)
                break;

            cnt++;
        }

        return cnt;
    }
}