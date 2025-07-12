// Question: https://leetcode.com/problems/search-a-2d-matrix-ii/description/

class SearchA2DMatrixTwo {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row: matrix) {
            if (Arrays.binarySearch(row, target) >= 0) {
                return true;
            }
        }
        return false;
    }
}