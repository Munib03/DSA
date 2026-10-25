class Solution {
public int maxScore(int[] cardPoints, int k) {
  var n = cardPoints.length;

  var leftSum = 0;
  var rightSum = 0;

  for (var i=0; i < k; i++)
    leftSum += cardPoints[i];

  var max = leftSum;
  var l = k - 1;
  var r = n - 1;

  while (l >= 0) {
    leftSum -= cardPoints[l];
    rightSum += cardPoints[r];

    var sum = leftSum + rightSum;
    max = Math.max(max, sum);

    l--;
    r--;
  }

  return max;
}
}