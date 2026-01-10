class Solution {
    public int longestPalindromeSubseq(String s) {
        var n = s.length();

        int[][] dp = new int[n][n];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        return matchNotMatch(0, n - 1, s, dp);
    }

    private int matchNotMatch(int l, int r, String str, int[][] dp) {
        if (l == r)
            return 1;

        else if (l > r)
            return 0;

        else if (dp[l][r] != -1)
            return dp[l][r];

        var me = str.charAt(l);
        var ou = str.charAt(r);

        if (me == ou)
            dp[l][r] = 2 + matchNotMatch(l + 1, r - 1, str, dp);

        else {
            var takeX = matchNotMatch(l + 1, r, str, dp);
            var takeY = matchNotMatch(l, r - 1, str, dp);

            var best = Math.max(takeX, takeY);
            dp[l][r] = best;
        }

        return dp[l][r];
    }
}