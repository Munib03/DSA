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

            while (((right - left) + 1 - maxSoFar) > k) {
                freqArr[s.charAt(left) - 'A']--;
                maxSoFar = 0;
                for (var val : freqArr)
                    maxSoFar = Math.max(maxSoFar, val);
                    
                left++;
            }

            for (var val : freqArr)
                maxSoFar = Math.max(maxSoFar, val);

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}