class Solution {
    public int numberOfSubstrings(String s) {
        var n = s.length();
        var cnt = 0;

        var lastASeen = -1;
        var lastBSeen = -1;
        var lastCSeen = -1;

        for (var i = 0; i < n; i++) {
            var ch = s.charAt(i);

            if (ch == 'a')
                lastASeen = i;
            else if (ch == 'b')
                lastBSeen = i;
            else
                lastCSeen = i;

            if (lastASeen != -1 && lastBSeen != -1 && lastCSeen != -1) {
                var min = Math.min(lastASeen, Math.min(lastBSeen, lastCSeen));

                cnt += min + 1;
            }
        }

        return cnt;
    }
}