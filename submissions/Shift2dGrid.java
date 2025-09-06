// Question: https://leetcode.com/problems/shift-2d-grid/description/

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;

        for (int i = 0; i < k; i++) {
            grid = update(grid);
        }
        for (int[] row: grid) {
            List<Integer> e = new ArrayList<>();
            for (int number: row) {
                e.add(number);
            }
            result.add(e);
        }
        if (isTest) {
            System.out.println("result:");
            for (List<Integer> e: result) {
                System.out.println(e);
            }
        }

        return result;
    }

    private int[][] update(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    result[i][j + 1] = grid[i][j];
                } else if (i + 1 < m && n - 1 >= 0) {
                    result[i + 1][0] = grid[i][n - 1];
                }
            }
        }
        result[0][0] = grid[m - 1][n - 1];

        return result;
    }
}