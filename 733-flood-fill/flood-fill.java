class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        var n = image.length;
        var m = image[0].length;

        var initialColor = image[sr][sc];
        if (initialColor == color)
            return image;

        var queue = new LinkedList<int[]>();

        queue.offer(new int[] { sr, sc });
        image[sr][sc] = color;

        int[][] directions = {
                { 1, 0 },
                { 0, 1 },
                { -1, 0 },
                { 0, -1 }
        };

        while (!queue.isEmpty()) {
            var frontOfQueue = queue.poll();

            var row = frontOfQueue[0];
            var col = frontOfQueue[1];

            for (var direction : directions) {
                var nr = row + direction[0];
                var nc = col + direction[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == initialColor) {
                    image[nr][nc] = color;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }

        return image;
    }
}