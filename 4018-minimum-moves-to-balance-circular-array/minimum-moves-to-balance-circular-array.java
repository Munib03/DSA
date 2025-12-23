class Solution {
    public long minMoves(int[] balance) {
        int n = balance.length;
        int neg = -1;
        long need = 0, have = 0;

        for (int i = 0; i < n; i++) {
            if (balance[i] < 0) {
                neg = i;
                need = -balance[i];
            } else {
                have += balance[i];
            }
        }

        if (need == 0)
            return 0;
        if (have < need)
            return -1;

        long moves = 0;
        int d = 1;

        while (need > 0) {
            int left = (neg - d + n) % n;
            int right = (neg + d) % n;

            if (balance[left] > 0) {
                long take = Math.min(balance[left], need);
                moves += take * d;
                need -= take;
                balance[left] -= take;
            }

            if (need > 0 && balance[right] > 0) {
                long take = Math.min(balance[right], need);
                moves += take * d;
                need -= take;
                balance[right] -= take;
            }

            d++;
        }

        return moves;
    }

}