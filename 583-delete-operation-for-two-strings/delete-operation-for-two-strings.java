class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2);
        return word1.length() + word2.length() - 2 * lcs;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return matchNotMatch(0, 0, text1, text2, dp);
    }

    private int matchNotMatch(int i, int j, String s, String t, int[][] dp) {
        if (i == s.length() || j == t.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = 1 + matchNotMatch(i + 1, j + 1, s, t, dp);
        } else {
            dp[i][j] = Math.max(
                    matchNotMatch(i + 1, j, s, t, dp),
                    matchNotMatch(i, j + 1, s, t, dp));
        }

        return dp[i][j];
    }
}