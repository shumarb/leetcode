// Question: https://leetcode.com/problems/largest-local-values-in-a-matrix/description/

class LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int startRow = 0;
        int[][] result = new int[n - 2][n - 2];

        while (startRow <= n - 3) {
            int startColumn = 0;
            while (startColumn <= n - 3) {
                int maximum = 0;

                for (int i = startRow; i < (startRow + 3); i++) {
                    for (int j = startColumn; j < (startColumn + 3); j++) {
                        maximum = Math.max(maximum, grid[i][j]);
                    }
                }

                result[startRow][startColumn] = maximum;
                startColumn++;
            }
            startRow++;
        }

        return result;
    }
}