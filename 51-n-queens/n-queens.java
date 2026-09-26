class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<char[][]> ans = new ArrayList<>();
    char[][] board = new char[n][n];

    for (var i = 0; i < n; i++)
      Arrays.fill(board[i], '.');

    dfs(0, n, ans, board);

    List<List<String>> realAns = new ArrayList<>();

    for (var arr : ans) {
      var temp = new ArrayList<String>();

      for (var row : arr)
        temp.add(new String(row));

      realAns.add(temp);
    }

    return realAns;
  }

  private void dfs(int col, int n, List<char[][]> ans, char[][] board) {
    if (col == n) {
      char[][] temp = new char[n][n];

      for (var i = 0; i < n; i++)
        temp[i] = board[i].clone();

      ans.add(temp);
      return;
    }

    for (var row = 0; row < n; row++) {
      if (isSafe(row, col, board, n)) {
        board[row][col] = 'Q';

        dfs(col + 1, n, ans, board);

        board[row][col] = '.';
      }
    }
  }

  private boolean isSafe(int row, int col, char[][] board, int n) {
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