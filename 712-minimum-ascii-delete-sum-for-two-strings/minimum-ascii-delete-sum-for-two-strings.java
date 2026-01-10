class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        var n = s1.length();
        var m = s2.length();

        int[][] dp = new int[n][m];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        return matchNotMath(0, 0, s1, s2, dp);
    }

    private int matchNotMath(int index1, int index2, String s1, String s2, int[][] dp) {
        if (index1 == s1.length()) {
            var rem = 0;

            for (var i = index2; i < s2.length(); i++)
                rem += s2.charAt(i);

            return rem;
        }

        else if (index2 == s2.length()) {
            var rem = 0;

            for (var i = index1; i < s1.length(); i++)
                rem += s1.charAt(i);

            return rem;
        }

        else if (dp[index1][index2] != -1)
            return dp[index1][index2];

        var me = s1.charAt(index1);
        var ou = s2.charAt(index2);

        if (me == ou)
            dp[index1][index2] = matchNotMath(index1 + 1, index2 + 1, s1, s2, dp);

        else {
            var deleteA = s1.charAt(index1) + matchNotMath(index1 + 1, index2, s1, s2, dp);
            var deleteB = s2.charAt(index2) + matchNotMath(index1, index2 + 1, s1, s2, dp);

            dp[index1][index2] = Math.min(deleteA, deleteB);
        }

        return dp[index1][index2];
    }

}