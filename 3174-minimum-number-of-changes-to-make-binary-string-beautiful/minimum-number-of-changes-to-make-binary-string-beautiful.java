class Solution {
    public int minChanges(String s) {
        var n = s.length();

        var cnt = 0;

        var left = 0;
        var right = 1;

        while (right < n) {
            var me = s.charAt(left);
            var ou = s.charAt(right);

            if (me != ou) {
                cnt++;
            }

            left += 2;
            right += 2;
        }

        return cnt;
    }
}