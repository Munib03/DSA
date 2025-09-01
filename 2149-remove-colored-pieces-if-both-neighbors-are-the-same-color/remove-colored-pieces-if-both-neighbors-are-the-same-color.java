class Solution {
    public boolean winnerOfGame(String colors) {
        var n = colors.length();

        var aliceMoves = 0;
        var bobMoves = 0;

        for (var i = 1; i < colors.length() - 1; i++) {
            var prev = colors.charAt(i - 1);
            var now = colors.charAt(i);
            var next = colors.charAt(i + 1);

            if (now == 'A' && prev == 'A' && next == 'A')
                aliceMoves++;

            else if (now == 'B' && prev == 'B' && next == 'B')
                bobMoves++;
        }

        return aliceMoves > bobMoves;
    }
}