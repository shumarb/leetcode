// Question: https://leetcode.com/problems/island-perimeter/description/

class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        boolean isTest = false;
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                int count = 0;

                if (i - 1 < 0 || grid[i - 1][j] == 0) {
                    count++;
                }
                if (i + 1 >= m || grid[i + 1][j] == 0) {
                    count++;
                }
                if (j - 1 < 0 || grid[i][j - 1] == 0) {
                    count++;
                }
                if (j + 1 >= n || grid[i][j + 1] == 0) {
                    count++;
                }
                if (isTest) {
                    System.out.println(" * [" + i + ", " + j + "]: " + count);
                }

                result += count;
            }
        }
        if (isTest) {
            System.out.println("---------------------------\nresult: " + result);
        }

        return result;
    }
}
