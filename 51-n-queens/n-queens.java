class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (var sth : board)
            Arrays.fill(sth, '.');

        dfs(0, n, ans, board);

        return ans;
    }

    private void dfs(int col, int n, List<List<String>> ans, char[][] board) {
        if (col == n) {
            var temp = new ArrayList<String>();

            for (var arr : board) {
                var sb = new StringBuilder();

                for (var ch : arr)
                    sb.append(ch);

                temp.add(sb.toString());
            }

            ans.add(new ArrayList<>(temp));
            return;
        }

        for (var row = 0; row < n; row++) {
            if (isSafeToPlaceQueen(row, col, n, board)) {
                board[row][col] = 'Q';
                dfs(col + 1, n, ans, board);

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