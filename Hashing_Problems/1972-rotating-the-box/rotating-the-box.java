class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        var n = boxGrid.length;
        var m = boxGrid[0].length;

        for (var i = 0; i < n; i++) {
            for (var j = m - 1; j >= 0; j--) {

                if (boxGrid[i][j] == '#') {
                    var f = j;

                    while (f < m - 1) {
                        if (boxGrid[i][f + 1] == '.') {
                            boxGrid[i][f + 1] = '#';
                            boxGrid[i][f] = '.';
                        } else
                            break;

                        f++;
                    }
                }

            }
        }

        return rotate90(boxGrid);

    }

    public char[][] rotate90(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        char[][] rotated = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = matrix[i][j];
            }
        }

        return rotated;
    }

}