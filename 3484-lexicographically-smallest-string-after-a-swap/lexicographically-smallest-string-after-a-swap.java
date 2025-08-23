class Solution {
    public String getSmallestString(String s) {
        var n = s.length();

        var sb = new StringBuilder();
        sb.append(s);

        var left = 0;
        var right = 1;

        while (right < n) {
            var me = Integer.parseInt(sb.charAt(left) + "");
            var ou = Integer.parseInt(sb.charAt(right) + "");

            if ((ou < me) && ((me % 2 == 0 && ou % 2 == 0) || (me % 2 == 1 && ou % 2 == 1))) {
                sb.setCharAt(left, (ou + "").charAt(0));
                sb.setCharAt(right, (me + "").charAt(0));

                return sb.toString();
            }

            left++;
            right++;
        }

        return sb.toString();
    }
}