class Solution {
    public String longestPalindrome(String s) {
        var start = 0;
        var end = 0;

        for (var i = 0; i < s.length(); i++) {
            var len1 = expand(s, i, i);
            var len2 = expand(s, i, i + 1);

            var len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
