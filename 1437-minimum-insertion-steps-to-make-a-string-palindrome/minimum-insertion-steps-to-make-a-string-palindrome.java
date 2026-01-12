class Solution {
public int minInsertions(String s) {
  var n = s.length();

  int[][] dp = new int[n + 1][n + 1];
  for (var sth: dp)
    Arrays.fill(sth, -1);

  return matchNotMatch(0, n - 1, s, dp);
}

private int matchNotMatch(int l, int r, String s, int[][] dp) {
  if (l >= r)
    return 0;

  else if (dp[l][r] != -1)
    return dp[l][r];

  var x = s.charAt(l);
  var y = s.charAt(r);

  if (x == y)
    dp[l][r] = matchNotMatch(l + 1, r - 1, s, dp);

  else {
    var op1 = 1 + matchNotMatch(l + 1, r, s, dp);
    var op2 = 1 + matchNotMatch(l, r - 1, s, dp);

    var best = Math.min(op1, op2);
    dp[l][r] = best;
  }

  return dp[l][r];
}
}