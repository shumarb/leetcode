// Question: https://leetcode.com/problems/count-servers-that-communicate/description/

class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && isValid(grid, i, j, m, n)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isValid(int[][] grid, int row, int column, int totalRows, int totalColumns) {
        for (int j = 0; j < grid[0].length; j++) {
            if (j == column) {
                continue;
            }
            if (grid[row][j] == 1) {
                return true;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            if (i == row) {
                continue;
            }
            if (grid[i][column] == 1) {
                return true;
            }
        }

        return false;
    }
}
