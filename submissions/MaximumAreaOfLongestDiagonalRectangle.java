// Question: https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/description/

class MaximumAreaOfLongestDiagonalRectangle {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maximumDiagonal = 0;
        int maximumArea = 0;

        for (int[] dimension: dimensions) {
            double diagonal = Math.sqrt(dimension[0] * dimension[0] + dimension[1] * dimension[1]);
            int area = dimension[0] * dimension[1];
            if (diagonal > maximumDiagonal || diagonal == maximumDiagonal && area > maximumArea) {
                maximumArea = area;
                maximumDiagonal = diagonal;
            }
        }

        return maximumArea;
    }
}