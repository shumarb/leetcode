// Question: https://leetcode.com/problems/search-a-2d-matrix-ii/description/

class SearchA2DMatrixTwo {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean isTest = false;
        int column = matrix[0].length - 1;
        int row = 0;

        if (isTest) {
            System.out.println("target: " + target + "\nmatrix:");
            for (int[] entry: matrix) {
                System.out.println(" * " + Arrays.toString(entry));
            }
        }

        while (column >= 0 && row < matrix.length) {
            int element = matrix[row][column];
            if (isTest) {
                System.out.println("-----------------------------------");
                System.out.println("row: " + row + ", column: " + column + " --> element: " + element);
            }
            if (element == target) {
                return true;

            } else if (element < target) {
                // 1. Move down to exclude all values <= element.
                row++;
            } else {
                // 2. Move left to exclude all values >= element.
                column--;
            }
        }

        return false;
    }
}