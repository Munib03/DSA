class Solution {
    public long minMoves(int[] balance) {
        var sum = 0L;
        var theNegNumIndex = Integer.MAX_VALUE;
        for (var i = 0; i < balance.length; i++) {
            if (balance[i] < 0)
                theNegNumIndex = i;

            sum += balance[i];
        }

        if (sum < 0)
            return -1;

        else if (theNegNumIndex == Integer.MAX_VALUE)
            return 0;

        var theDistanceArr = distancesToNegative(balance);
        var theNum = balance[theNegNumIndex];

        var cnt = 0L;

        for (var i = 1; i < theDistanceArr.length; i++) {
            var currNum = theDistanceArr[i][0];
            var theDistance = theDistanceArr[i][1];

            if (currNum <= 0)
                continue;

            if (currNum < Math.abs(theNum)) {
                cnt += currNum * theDistance;
                theNum += (int) currNum;
            } else {
                cnt += Math.abs(theNum) * theDistance;
                break;
            }
        }

        return cnt;
    }

    private long[][] distancesToNegative(int[] balance) {
        int n = balance.length;
        int negIdx = -1;

        for (int i = 0; i < n; i++) {
            if (balance[i] < 0) {
                negIdx = i;
                break;
            }
        }

        long[][] res = new long[n][2];

        for (int i = 0; i < n; i++) {
            int clockwise = (i - negIdx + n) % n;
            int anticlockwise = (negIdx - i + n) % n;
            int dist = Math.min(clockwise, anticlockwise);

            res[i][0] = balance[i];
            res[i][1] = dist;
        }

        Arrays.sort(res, Comparator.comparingLong(a -> a[1]));

        return res;
    }

}