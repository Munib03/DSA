class Solution {
    public int minDistance(String word1, String word2) {
        var n = word1.length();
        var m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        return matchNotMatch(0, 0, word1, word2, dp);
    }

    private int matchNotMatch(int index1, int index2, String s1, String s2, int[][] dp) {
        if (index1 == s1.length())
            return s2.length() - index2;

        else if (index2 == s2.length())
            return s1.length() - index1;

        else if (dp[index1][index2] != -1)
            return dp[index1][index2];

        var me = s1.charAt(index1);
        var ou = s2.charAt(index2);

        if (me == ou)
            dp[index1][index2] = matchNotMatch(index1 + 1, index2 + 1, s1, s2, dp);

        else {
            var deleteA = 1 + matchNotMatch(index1 + 1, index2, s1, s2, dp);
            var deleteB = 1 + matchNotMatch(index1, index2 + 1, s1, s2, dp);

            var min = Math.min(deleteA, deleteB);
            dp[index1][index2] = min;
        }

        return dp[index1][index2];
    }
}