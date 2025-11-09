class Solution {
    public void solve(char[][] board) {
        var n = board.length;
        var m = board[0].length;

        var queue = new LinkedList<int[]>();

        for (var i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[] { 0, i });
                board[0][i] = 'M';
            }

            if (board[n - 1][i] == 'O') {
                queue.offer(new int[] { n - 1, i });
                board[n-1][i] = 'M';
            }
        }

        for (var i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[] { i, 0 });
                board[i][0] = 'M';
            }

            if (board[i][m - 1] == 'O') {
                queue.offer(new int[] { i, m - 1 });
                board[i][m-1] = 'M';
            }
        }

        int[] rows = { -1, 0, 1, 0 };
        int[] cols = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            var topOfQueue = queue.poll();
            var row = topOfQueue[0];
            var col = topOfQueue[1];

            for (var i = 0; i < rows.length; i++) {
                var newRow = row + rows[i];
                var newCol = col + cols[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && board[newRow][newCol] == 'O') {
                    queue.offer(new int[] { newRow, newCol });
                    board[newRow][newCol] = 'M';
                }
            }
        }

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                if (board[i][j] == 'M')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

}