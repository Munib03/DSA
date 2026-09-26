class Solution {
    private int cnt = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (var sth : board)
            Arrays.fill(sth, '.');

        dfs(0, n, board);

        return cnt;
    }

    private void dfs(int col, int n, char[][] board) {
        if (col == n) {
            cnt++;
            return;
        }

        for (var row = 0; row < n; row++) {
            if (isSafeToPlaceQueen(row, col, n, board)) {
                board[row][col] = 'Q';
                dfs(col + 1, n, board);

                board[row][col] = '.';
            }
        }
    }

    private boolean isSafeToPlaceQueen(int row, int col, int n, char[][] board) {

        for (var i = 0; i < col; i++) {
            if (board[row][i] == 'Q')
                return false;

            var up = row - (col - i);
            var down = row + (col - i);

            if (up >= 0 && board[up][i] == 'Q')
                return false;

            if (down < n && board[down][i] == 'Q')
                return false;
        }

        return true;
    }
}