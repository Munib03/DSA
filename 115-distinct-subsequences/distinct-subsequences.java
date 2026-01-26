class Solution {
    public int numDistinct(String s, String t) {
        var n = s.length();
        var m = t.length();

        int[][] dp = new int[n + 1][m + 1];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        return matchNotMatch(0, 0, s, t, dp);
    }

    private int matchNotMatch(int i, int j, String s, String p, int[][] dp) {
        if (j == p.length())
            return 1;

        else if (i >= s.length())
            return 0;

        else if (dp[i][j] != -1)
            return dp[i][j];

        var me = s.charAt(i);
        var ou = p.charAt(j);

        if (me == ou) {
            var pick = matchNotMatch(i + 1, j + 1, s, p, dp);
            var notPick = matchNotMatch(i + 1, j, s, p, dp);

            dp[i][j] = pick + notPick;
        }

        else
            return matchNotMatch(i + 1, j, s, p, dp);

        return dp[i][j];
    }
}