class Solution {
    public int minDistance(String word1, String word2) {
        var n = word1.length();
        var m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        return matchNotMatch(0, 0, word1, word2, dp);
    }

    private int matchNotMatch(int i, int j, String s, String t, int[][] dp) {
        if (i >= s.length())
            return t.length() - j;

        else if (j >= t.length())
            return s.length() - i;

        else if (dp[i][j] != -1)
            return dp[i][j];

        var me = s.charAt(i);
        var ou = t.charAt(j);

        if (me == ou)
            return matchNotMatch(i + 1, j + 1, s, t, dp);

        else {
            var deleteI = 1 + matchNotMatch(i + 1, j, s, t, dp);
            var deleteJ = 1 + matchNotMatch(i, j + 1, s, t, dp);

            dp[i][j] = Math.min(deleteI, deleteJ);
        }

        return dp[i][j];
    }
}