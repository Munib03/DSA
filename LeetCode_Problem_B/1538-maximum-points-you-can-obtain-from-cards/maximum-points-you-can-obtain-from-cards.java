class Solution {
    public int maxScore(int[] cardPoints, int k) {
        var n = cardPoints.length;

        var leftSum = 0;
        for (var i = 0; i < k; i++)
            leftSum += cardPoints[i];

        var max = leftSum;
        var rightSum = 0;

        var left = k - 1;
        var right = n - 1;

        while (left >= 0) {
            leftSum -= cardPoints[left--];
            rightSum += cardPoints[right--];

            max = Math.max(max, rightSum + leftSum);
        }

        return max;
    }
}