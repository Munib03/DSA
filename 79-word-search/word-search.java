class Solution {
    public boolean exist(char[][] board, String word) {
        var n = board.length;
        var m = board[0].length;

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(board, new boolean[n][m], i, j, new StringBuilder(), word);

                    if (ansFlag)
                        return true;
                }
            }
        }

        return false;
    }

    private boolean ansFlag = false;

    private void dfs(char[][] board, boolean[][] visited, int row, int col, StringBuilder sb, String word) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col])
            return;

        sb.append(board[row][col]);
        if (sb.toString().equals(word)) {
            ansFlag = true;
            return;
        }

        if (!word.startsWith(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        visited[row][col] = true;

        dfs(board, visited, row + 1, col, sb, word);
        dfs(board, visited, row - 1, col, sb, word);
        dfs(board, visited, row, col + 1, sb, word);
        dfs(board, visited, row, col - 1, sb, word);

        visited[row][col] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

}