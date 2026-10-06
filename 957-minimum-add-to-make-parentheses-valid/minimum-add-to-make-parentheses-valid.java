class Solution {
    public int minAddToMakeValid(String s) {
        var openings = 0;
        var cnt = 0;

        for (var ch : s.toCharArray()) {
            if (ch == '(')
                openings++;

            else {
                if (openings == 0)
                    cnt++;
                else
                    openings--;
            }
        }

        return cnt + openings;
    }
}