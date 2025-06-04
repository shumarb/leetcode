// Question: https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/description/

class CellsWithOddValuesInAMatrix {
    public int oddCells(int m, int n, int[][] indices) {
        boolean isTest = false;
        int countOddCells = 0;
        int[][] matrix = new int[m][n];

        for (int[] entry: indices) {
            if (isTest) {
                System.out.println("entry: " + Arrays.toString(entry));
            }
            updateRow(entry[0], matrix);
            updateColumn(entry[1], matrix);
            if (isTest) {
                display(matrix);
            }
        }

        if (isTest) {
            display(matrix);
        }

        for (int[] row: matrix) {
            for (int element: row) {
                if (element % 2 != 0) {
                    countOddCells++;
                }
            }
        }

        return countOddCells;
    }

    private void updateColumn(int columnNumber, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][columnNumber]++;
        }
    }

    private void display(int[][] matrix) {
        for (int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("----------------------------------------------");
    }

    private void updateRow(int rowNumber, int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[rowNumber][i]++;
        }
    }
}