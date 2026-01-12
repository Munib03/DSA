class Solution {
    public int minDistance(String word1, String word2) {
        var n = word1.length();
        var m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        return matchNotMatch(0, 0, word1, word2, dp);
    }

    private int matchNotMatch(int i, int j, String s1, String s2, int[][] dp) {
        if (i == s1.length())
            return s2.length() - j;

        else if (j == s2.length())
            return s1.length() - i;

        else if (dp[i][j] != -1)
            return dp[i][j];

        var x = s1.charAt(i);
        var y = s2.charAt(j);

        if (x == y)
            dp[i][j] = matchNotMatch(i + 1, j + 1, s1, s2, dp);
        else {
            var a = 1 + matchNotMatch(i + 1, j, s1, s2, dp);
            var b = 1 + matchNotMatch(i, j + 1, s1, s2, dp);

            var best = Math.min(a, b);
            dp[i][j] = best;
        }

        return dp[i][j];
    }
}