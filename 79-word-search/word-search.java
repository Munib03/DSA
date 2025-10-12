class Solution {
    private final List<String> ansList = new ArrayList<>();

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, new boolean[n][m], i, j, new StringBuilder(), word);
            }
        }

        for (String s : ansList)
            if (s.equals(word))
                return true;

        return false;
    }

    private void dfs(char[][] board, boolean[][] visited, int row, int col, StringBuilder sb, String word) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col])
            return;

        sb.append(board[row][col]);

        if (!word.startsWith(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        ansList.add(sb.toString());

        if (sb.length() == word.length()) {
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
