class Solution {
    public int longestMountain(int[] arr) {
        var n = arr.length;

        var increasingFlag = true;
        var maxLen = 0;
        var cnt = 0;

        for (var i = 0; i < n - 1; i++) {
            var currElement = arr[i];
            var nextElement = arr[i + 1];

            if (nextElement > currElement && !increasingFlag) {
                increasingFlag = true;
                cnt = 0;
            }

            if (increasingFlag && nextElement > currElement)
                cnt++;

            else if (cnt > 0 && nextElement < currElement) {
                increasingFlag = false;
                cnt++;
                maxLen = Math.max(cnt, maxLen);
            } else {
                cnt = 0;
                increasingFlag = true;
            }

            
        }

        if (maxLen == 0)
            return 0;

        return maxLen + 1;
    }
}