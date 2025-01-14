// Question: https://leetcode.com/problems/set-matrix-zeroes/description/

class Solution {
    public void setZeroes(int[][] matrix) {
        int[] rowArr = new int[matrix.length];
        int[] colArr = new int[matrix[0].length];
        Arrays.fill(rowArr, 1);
        Arrays.fill(colArr, 1);
        boolean t = false;
        if (t) {
            System.out.println("before:");
            System.out.println("rowArr: " + Arrays.toString(rowArr));
            System.out.println("colArr: " + Arrays.toString(colArr));
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowArr[i] = 0;
                    colArr[j] = 0;
                }
            }
        }
        if (t) {
            System.out.println("after:");
            System.out.println("rowArr: " + Arrays.toString(rowArr));
            System.out.println("colArr: " + Arrays.toString(colArr));
        }

        for (int i = 0; i < rowArr.length; i++) {
            if (rowArr[i] == 0) {
                makeRowZero(matrix, i);
            }
        }

        for (int i = 0; i < colArr.length; i++) {
            if (colArr[i] == 0) {
                makeColZero(matrix, i);
            }
        }
    }

    private void makeColZero(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = matrix[i];
            arr[col] = 0;
        }
    }

    private void makeRowZero(int[][] matrix, int row) {
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = matrix[i];
            if (row == i) {
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = 0;
                }
                break;
            }
        }
    }
}