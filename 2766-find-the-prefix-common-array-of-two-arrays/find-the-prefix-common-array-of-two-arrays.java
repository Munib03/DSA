class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        var n = A.length;
        int[] ansArr = new int[n];
        int[] freq = new int[n + 1];

        var cnt = 0;
        for (var i = 0; i < n; i++) {
            if (++freq[A[i]] == 2)
                cnt++;

            if (++freq[B[i]] == 2)
                cnt++;

            ansArr[i] = cnt;
        }

        return ansArr;
    }
}