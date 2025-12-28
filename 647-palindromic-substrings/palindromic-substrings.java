class Solution {
    public int countSubstrings(String s) {
        var n = s.length();
        var cnt = 0;

        for (var i = 0; i < n; i++) {
            var oddLenCenter = expandAroundCenter(s, i, i);
            var evenLenCenter = expandAroundCenter(s, i, i + 1);

            cnt += oddLenCenter + evenLenCenter;
        }

        return cnt;
    }

    private int expandAroundCenter(String s, int left, int right) {
        var cnt = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }

        return cnt;
    }
}