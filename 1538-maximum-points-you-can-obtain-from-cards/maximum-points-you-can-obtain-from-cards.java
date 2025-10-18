class Solution {
    public int maxScore(int[] cardPoints, int k) {
        var n = cardPoints.length;

        var leftSum = 0;
        var rightSum = 0;

        for (var i = 0; i < k; i++)
            leftSum += cardPoints[i];

        var max = leftSum;

        var lastIndex = n - 1;
        for (var i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[lastIndex--];

            var currSum = leftSum + rightSum;
            max = Math.max(max, currSum);
        }

        return max;
    }
}