class Solution {
    public int numberOfSubstrings(String s) {
        var n = s.length();

        var cnt = 0;
        var aLastSeen = -1;
        var bLastSeen = -1;
        var cLastSeen = -1;

        for (var i = 0; i < n; i++) {
            var curr = s.charAt(i);

            switch (curr) {
                case 'a' -> aLastSeen = i;
                case 'b' -> bLastSeen = i;
                case 'c' -> cLastSeen = i;
            }

            if (aLastSeen != -1 && bLastSeen != -1 && cLastSeen != -1) {
                var min = Math.min(aLastSeen, Math.min(bLastSeen, cLastSeen));
                cnt += min + 1;
            }
        }

        return cnt;
    }
}