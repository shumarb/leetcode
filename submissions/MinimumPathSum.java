// Question: https://leetcode.com/problems/minimum-path-sum/description/

class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        boolean isTest = false;
        int totalColumns = grid[0].length;
        int totalRows = grid.length;

        if (isTest) {
            display("before, grid:", grid);
        }
        for (int i = 1; i < totalRows; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < totalColumns; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < totalRows; i++) {
            for (int j = 1; j < totalColumns; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        if (isTest) {
            display("after, grid:", grid);
            System.out.println("min path sum: " + grid[totalRows - 1][totalColumns - 1]);
        }

        return grid[totalRows - 1][totalColumns - 1];
    }

    private void display(String sentence, int[][] grid) {
        System.out.println(sentence);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------------------------------------");
    }
}