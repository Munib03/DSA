class Solution {
    public void solve(char[][] board) {
        var n = board.length;
        var m = board[0].length;

        var queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[n][m];

        // This for first row and last row
        for (var i = 0; i < m; i++) {
            if (!visited[0][i] && board[0][i] == 'O') {
                queue.offer(new int[] { 0, i });
                visited[0][i] = true;
                board[0][i] = 'M';
            }

            if (!visited[n - 1][i] && board[n - 1][i] == 'O') {
                queue.offer(new int[] { n - 1, i });
                visited[n - 1][i] = true;
                board[n - 1][i] = 'M';
            }
        }

        // This is for first and last column
        for (var i = 0; i < n; i++) {
            if (!visited[i][0] && board[i][0] == 'O') {
                queue.offer(new int[] { i, 0 });
                visited[i][0] = true;
                board[i][0] = 'M';
            }

            if (!visited[i][m - 1] && board[i][m - 1] == 'O') {
                queue.offer(new int[] { i, m - 1 });
                visited[i][m - 1] = true;
                board[i][m - 1] = 'M';
            }
        }

        int[] rows = { -1, 0, 1, 0 };
        int[] cols = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            var topOfQueue = queue.pop();
            var row = topOfQueue[0];
            var col = topOfQueue[1];

            for (var i = 0; i < rows.length; i++) {
                var newRow = row + rows[i];
                var newCol = col + cols[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]
                        && board[newRow][newCol] == 'O') {
                    queue.offer(new int[] { newRow, newCol });
                    visited[newRow][newCol] = true;
                    board[newRow][newCol] = 'M';
                }
            }
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

}