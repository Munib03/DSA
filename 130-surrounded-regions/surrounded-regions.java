class Solution {
public char[][] solve(char[][] board) {
  int n = board.length;        
  int m = board[0].length;     

  for (int i = 0; i < n; i++) {
    if (board[i][0] == 'O')
      dfs(board, i, 0);
  }

  for (int i = 0; i < n; i++) {
    if (board[i][m - 1] == 'O')
      dfs(board, i, m - 1);
  }

  for (int j = 0; j < m; j++) {
    if (board[0][j] == 'O')
      dfs(board, 0, j);
  }

  for (int j = 0; j < m; j++) {
    if (board[n - 1][j] == 'O')
      dfs(board, n - 1, j);
  }
  
  for (var i = 0; i < n; i++) {
    for (var j = 0; j < m; j++) {
      if (board[i][j] == 'M')
        board[i][j] = 'O';
      else
        board[i][j] = 'X';
    }
  }

  return board;
}

private void dfs(char[][] ans, int row, int col) {
  if (row < 0 || col < 0 || row >= ans.length || col >= ans[0].length)
    return;

  else if (ans[row][col] != 'O')
    return;

  else if (ans[row][col] == 'O')
    ans[row][col] = 'M';

  dfs(ans, row + 1, col);
  dfs(ans, row - 1, col);
  dfs(ans, row, col + 1);
  dfs(ans, row, col - 1);
}
}