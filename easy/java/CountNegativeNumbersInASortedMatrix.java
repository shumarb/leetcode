// Question: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int countNegative = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    countNegative++;
                }
            }
        }
        return countNegative;
    }
}