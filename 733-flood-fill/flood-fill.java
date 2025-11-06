class Solution {
public int[][] floodFill(int[][] image, int sr, int sc, int color) {
  var initialColor = image[sr][sc];
  if (initialColor == color)
    return image;

  dfs(image, sr, sc, initialColor, color);

  return image;
}

private void dfs(int[][] image, int row, int col, int initialColor, int color) {
  if (row < 0 || row >= image.length || col < 0 || col >= image[row].length || image[row][col] != initialColor)
    return;

  image[row][col] = color;

  dfs(image, row + 1, col, initialColor, color);
  dfs(image, row - 1, col, initialColor, color);
  dfs(image, row, col + 1, initialColor, color);
  dfs(image, row, col - 1, initialColor, color);

}

}