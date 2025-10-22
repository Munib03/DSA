class Solution {
    public void solve(char[][] board) {
        var n = board.length;
        var m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        // This for first row and last row
        for (var i = 0; i < m; i++) {
            if (!visited[0][i] && board[0][i] == 'O')
                dfs(board, 0, i, visited);

            if (!visited[n - 1][i] && board[n - 1][i] == 'O')
                dfs(board, n - 1, i, visited);
        }

        // This is for first and last column
        for (var i = 0; i < n; i++) {
            if (!visited[i][0] && board[i][0] == 'O')
                dfs(board, i, 0, visited);

            if (!visited[i][m - 1] && board[i][m - 1] == 'O')
                dfs(board, i, m - 1, visited);
        }

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                var curr = board[i][j];

                if (curr == 'M')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }

    }

    private void dfs(char[][] board, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length
                || visited[row][col] || board[row][col] != 'O')
            return;

        visited[row][col] = true;
        board[row][col] = 'M';

        dfs(board, row + 1, col, visited);
        dfs(board, row - 1, col, visited);
        dfs(board, row, col + 1, visited);
        dfs(board, row, col - 1, visited);

    }

}