class Solution {
    public int lengthOfLongestSubstring(String s) {
        var n = s.length();
        if (n == 0)
            return 0;

        var maxLen = 0;
        int[] freqArr = new int[256];

        var left = 0;
        var right = 0;

        while (right < n) {
            var ou = s.charAt(right);
            freqArr[ou]++;

            var currOuFreq = freqArr[ou];
            if (currOuFreq > 1) {
                while (freqArr[ou] > 1) {
                    freqArr[s.charAt(left)]--;
                    left++;
                }
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}