class Solution {
    public int characterReplacement(String s, int k) {
        var n = s.length();
        var maxLen = 0;

        var maxSoFar = 0;
        int[] freqArr = new int[26];

        var left = 0;
        var right = 0;

        while (right < n) {
            var ou = s.charAt(right);

            freqArr[ou - 'A']++;
            maxSoFar = Math.max(maxSoFar, freqArr[ou - 'A']);

            if (((right - left) + 1 - maxSoFar) > k) {
                freqArr[s.charAt(left) - 'A']--;
                left++;
            }

            else 
                maxLen = Math.max(maxLen, right - left + 1);
    
            right++;
        }

        return maxLen;
    }
}