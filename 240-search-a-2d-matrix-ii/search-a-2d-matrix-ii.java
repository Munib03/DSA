class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        var n = matrix.length;
        var m = matrix[0].length;

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                var currNum = matrix[i][j];

                if (currNum == target)
                    return true;
            }
        }

        return false;
    }
}