class Solution {
    public int findContentChildren(int[] g, int[] s) {
        var n = g.length;
        var m = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        var cnt = 0;

        var left = 0;
        var right = 0;

        while (left < n && right < m) {
            var greedFactor = g[left];
            var cookieSize = s[right];

            if (greedFactor <= cookieSize) {
                cnt++;

                left++;
            }

            right++;
        }

        return cnt;
    }

}