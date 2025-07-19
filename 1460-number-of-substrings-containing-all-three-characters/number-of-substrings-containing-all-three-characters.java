class Solution {
    public int numberOfSubstrings(String s) {
        var n = s.length();
        var cnt = 0;

        var left = 0;
        var right = 0;

        int[] freq = new int[3];

        while (right < n) {
            var ou = s.charAt(right);

            freq[ou - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                cnt += n - right;
                freq[s.charAt(left) - 'a']--;

                left++;
            }

            right++;
        }

        return cnt;
    }
}