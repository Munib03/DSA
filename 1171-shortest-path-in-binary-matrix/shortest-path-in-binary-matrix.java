class Solution {
public int shortestPathBinaryMatrix(int[][] grid) {
  var n = grid.length;
  var m = grid[0].length;

  if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
    return -1;

  var path = 1;

  var set = new HashSet<String>();
  set.add("0,0");

  var queue = new LinkedList<Pair>();
  queue.offer(new Pair(0, 0));

  int[] rows = {-1, -1, -1, 0, 0, 1, 1, 1};
  int[] cols = {-1, 0, 1, -1, 1, -1, 0, 1};

  while (!queue.isEmpty()) {
    var size = queue.size();

    while (size-- > 0) {
      var topOfQueue = queue.poll();
      var row = topOfQueue.row;
      var col = topOfQueue.col;

      if (row == n - 1 && col == m - 1)
        return path;

      for (var i = 0; i < rows.length; i++) {
        var newRow = row + rows[i];
        var newCol = col + cols[i];

        var key = newRow + ", " + newCol;

        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 0 && !set.contains(key)) {
          queue.offer(new Pair(newRow, newCol));
          set.add(key);
        }
      }
    }

    path++;
  }

  return -1;
}

private record Pair(int row, int col) {

}

}