class Solution {
    public int candy(int[] ratings) {
        var n = ratings.length;

        int[] leftArr = new int[n];
        leftArr[0] = 1;

        for (var i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                leftArr[i] = leftArr[i - 1] + 1;
            else
                leftArr[i] = 1;
        }

        int[] rightArr = new int[n];
        rightArr[n - 1] = 1;

        for (var i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                rightArr[i] = rightArr[i + 1] + 1;
            else
                rightArr[i] = 1;
        }

        var sum = 0;
        for (var i = 0; i < n; i++)
            sum += Math.max(leftArr[i], rightArr[i]);

        return sum;
    }
}