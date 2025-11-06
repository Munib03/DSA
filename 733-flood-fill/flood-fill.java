class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        var n = image.length;
        var m = image[0].length;

        var initialColor = image[sr][sc];
        if (initialColor == color)
            return image;

        int[] rows = { -1, 0, 1, 0 };
        int[] cols = { 0, 1, 0, -1 };

        image[sr][sc] = color;

        var queue = new LinkedList<int[]>();
        queue.offer(new int[] { sr, sc });

        while (!queue.isEmpty()) {
            var topOfQueue = queue.poll();
            var row = topOfQueue[0];
            var col = topOfQueue[1];

            for (var i = 0; i < rows.length; i++) {
                var newRow = row + rows[i];
                var newCol = col + cols[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && image[newRow][newCol] == initialColor) {
                    queue.offer(new int[] { newRow, newCol });
                    image[newRow][newCol] = color;
                }
            }
        }

        return image;
    }

}