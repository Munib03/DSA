class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        var initialColor = image[sr][sc];
        if (initialColor == color)
            return image;

        dfs(image, sr, sc, color, initialColor);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int color, int initialColor) {
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length)
            return;

        else if (image[row][col] != initialColor)
            return;

        image[row][col] = color;

        dfs(image, row, col + 1, color, initialColor);
        dfs(image, row, col - 1, color, initialColor);
        dfs(image, row + 1, col, color, initialColor);
        dfs(image, row - 1, col, color, initialColor);
    }
}