class Solution {
    public int numberOfSubstrings(String s) {
        var n = s.length();

        var cnt = 0;
        int[] freqArr = new int[3];
        Arrays.fill(freqArr, -1);

        for (var i = 0; i < n; i++) {
            var ou = s.charAt(i);

            freqArr[ou - 'a'] = i;

            if (freqArr[0] != -1 && freqArr[1] != -1 && freqArr[2] != -1) {
                var min = Math.min(freqArr[0], Math.min(freqArr[1], freqArr[2]));
                cnt += min + 1;
            }
        }

        return cnt;
    }
}