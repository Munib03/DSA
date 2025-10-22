class Solution {
public int[][] updateMatrix(int[][] mat) {
  var n = mat.length;
  var m = mat[0].length;

  int[][] ans = new int[n][m];
  var queue = new LinkedList<Triple>();
  var set = new HashSet<String>();

  for (var i=0; i < n; i++) {
    for (var j=0; j < m; j++) {
      var curr = mat[i][j];

      if (curr == 0) {
        queue.offer(new Triple(i, j, 0));
        set.add(i + ", " + j);
        ans[i][j] = 0;
      }
      else
        ans[i][j] = Integer.MAX_VALUE;
    }
  }

  int[] rows = {-1, 0, 1, 0};
  int[] cols = {0, 1, 0, -1};

  while (!queue.isEmpty()) {
    var topOfQueue = queue.pop();
    var row = topOfQueue.row;
    var col = topOfQueue.col;
    var numOfSteps = topOfQueue.numberOfSteps;

    for (var i=0; i < rows.length; i++) {
      var newRow = rows[i] + row;
      var newCol = cols[i] + col;

      if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !set.contains(newRow + ", " + newCol)) {
        queue.offer(new Triple(newRow, newCol, numOfSteps + 1));
        set.add(newRow + ", " + newCol);
        ans[newRow][newCol] = numOfSteps + 1;
      }
    }
  }

  return ans;
}

private record Triple(int row, int col, int numberOfSteps) {

}
}