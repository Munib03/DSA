class Solution {
    public int[] decrypt(int[] code, int k) {
        var n = code.length;
        if (k == 0)
            return new int[n];

        int[] ans = new int[n];
        for (var i = 0; i < n; i++) {
            var firstSum = 0;

            var copy = k;
            var f = 0;

            if (copy > 0) {
                f = i + 1;
                while (copy-- > 0) {
                    if (f == n)
                        f = 0;

                    firstSum += code[f];
                    f++;
                }
            } else {
                f = i - 1;
                while (copy++ < 0) {
                    if (f == -1)
                        f = n - 1;

                    firstSum += code[f];
                    f--;
                }
            }

            ans[i] = firstSum;
        }

        return ans;
    }
}