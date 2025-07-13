class Solution {
    public String largestMerge(String word1, String word2) {
        var n = word1.length();
        var m = word2.length();

        var sb = new StringBuilder();

        var i = 0;
        var j = 0;

        while (i < n && j < m) {
            var me = word1.charAt(i);
            var ou = word2.charAt(j);

            if (me > ou) {
                sb.append(me);
                i++;
            }

            else if (ou > me) {
                sb.append(ou);
                j++;
            }

            else {
                var ss1 = word1.substring(i + 1);
                var ss2 = word2.substring(j + 1);

                if (ss1.compareTo(ss2) > 0)
                    sb.append(word1.charAt(i++));
                else
                    sb.append(word2.charAt(j++));
            }
        }

        while (i < n)
            sb.append(word1.charAt(i++));

        while (j < m)
            sb.append(word2.charAt(j++));

        return sb.toString();
    }
}