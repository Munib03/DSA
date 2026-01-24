class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        var n = text1.length();
        var m = text2.length();

        int[][] dp = new int[n][m];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        return matchNotMatch(0, 0, text1, text2, dp);
    }

    private int matchNotMatch(int i, int j, String s1, String s2, int[][] dp) {
        if (i >= s1.length() || j >= s2.length())
            return 0;

        else if (dp[i][j] != -1)
            return dp[i][j];

        var me = s1.charAt(i);
        var ou = s2.charAt(j);

        if (me == ou)
            return 1 + matchNotMatch(i + 1, j + 1, s1, s2, dp);

        else {
            var skipS1 = matchNotMatch(i, j + 1, s1, s2, dp);
            var skipS2 = matchNotMatch(i + 1, j, s1, s2, dp);

            dp[i][j] = Math.max(skipS1, skipS2);
        }

        return dp[i][j];
    }
}