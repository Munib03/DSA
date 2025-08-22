class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        var total = 0;

        while (k > 0 && numOnes > 0) {
            total += 1;
            numOnes--;
            k--;
        }

        k -= numZeros;
        while (k > 0 && numNegOnes > 0) {
            total -= 1;
            k--;
            numNegOnes--;
        }

        return total;
    }
}