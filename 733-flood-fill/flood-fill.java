class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        var n = image.length;
        var m = image[0].length;

        var initialColor = image[sr][sc];
        if (initialColor == color)
            return image;

        dfs(image, sr, sc, color, initialColor, new boolean[n][m]);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int color, int initialColor, boolean[][] visited) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[row].length || image[row][col] != initialColor
                || visited[row][col])
            return;

        visited[row][col] = true;
        image[row][col] = color;

        dfs(image, row + 1, col, color, initialColor, visited);
        dfs(image, row - 1, col, color, initialColor, visited);
        dfs(image, row, col + 1, color, initialColor, visited);
        dfs(image, row, col - 1, color, initialColor, visited);

        visited[row][col] = false;
    }

}