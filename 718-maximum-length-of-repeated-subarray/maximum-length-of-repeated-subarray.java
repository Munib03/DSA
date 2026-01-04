class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        var n = nums1.length;
        var m = nums2.length;

        int[][] dp = new int[n][m];
        for (var sth : dp)
            Arrays.fill(sth, -1);

        for (var i = 0; i < n; i++)
            for (var j = 0; j < m; j++)
                matchNotMatch(i, j, nums1, nums2, dp);

        return maxLen;
    }

    private int maxLen = 0;

    private int matchNotMatch(int i, int j, int[] nums1, int[] nums2, int[][] dp) {
        if (i == nums1.length || j == nums2.length)
            return 0;

        else if (dp[i][j] != -1)
            return dp[i][j];

        if (nums1[i] == nums2[j]) {
            dp[i][j] = 1 + matchNotMatch(i + 1, j + 1, nums1, nums2, dp);
            maxLen = Math.max(maxLen, dp[i][j]);
        }

        else
            dp[i][j] = 0;
        return dp[i][j];
    }

}