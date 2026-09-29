class Solution {
    public boolean isValidSudoku(char[][] board) {
        var n = board.length;
        var m = board[0].length;

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                var curr = board[i][j];

                if (curr != '.') {
                    if (!isValid(board, i, j, curr))
                        return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {

        for (var i = 0; i < 9; i++) {
            if (i != row && board[i][col] == c)
                return false;

            if (i != col && board[row][i] == c)
                return false;

            var r = 3 * (row / 3) + i / 3;
            var c2 = 3 * (col / 3) + i % 3;

            if ((r != row || c2 != col) && board[r][c2] == c)
                return false;
        }

        return true;
    }
}