class Solution {
    public int minimumOperations(int[][] grid) {
        var n = grid.length;

        var cnt = 0;

        for (var i = 0; i < grid[0].length; i++) {
            var first = grid[0][i];

            for (var j = 1; j < n; j++) {
                var now = grid[j][i];

                if (now <= first) {

                    var diff = Math.abs(first - grid[j][i]);
                    diff++;

                    cnt += diff;
                    grid[j][i] = grid[j][i] + diff;
                }

                first = grid[j][i];
            }
        }

        return cnt;
    }
}