// Question: https://leetcode.com/problems/largest-triangle-area/description/

class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double largestTriangleArea = 0;
        int len = points.length;

        /**
         1.  Look through all possible combination of three points from the given points,
         calculate the triangle area formed by the three points,
         and determine if it is the largest triangle area that can be formed.
         */
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    largestTriangleArea = Math.max(largestTriangleArea, calculateTriangleArea(points[i], points[j], points[k]));
                }
            }
        }

        return largestTriangleArea;
    }

    private double calculateTriangleArea(int[] point1, int[] point2, int[] point3) {
        // 2. Use Triangle Area Determinant formula on the 3 points.
        double first = point1[0] * (point2[1] - point3[1]);
        double second = point2[0] * (point3[1] - point1[1]);
        double third = point3[0] * (point1[1] - point2[1]);
        return 0.5 * Math.abs(first + second + third);
    }
}