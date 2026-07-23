// Question: https://leetcode.com/problems/rotate-image/description/

class RotateImage {
    private int[][] matrix;
    private int n;

    public void rotate(int[][] matrix) {
        boolean isTest = false;
        n = matrix.length;
        this.matrix = matrix;

        if (n == 1) {
            return;
        }

        if (isTest) {
            print("before swapping column values:");
        }
        for (int column = 0; column < n; column++) {
            swap(column);
        }
        if (isTest) {
            print("after swapping column values:");
        }

        for (int i = 0; i < n; i++) {
            int adjacentColumn = i + 1;
            int adjacentRow = i + 1;

            while (adjacentColumn < n && adjacentRow < n) {
                if (isTest) {
                    System.out.println(" * swap [" + adjacentRow + ", " + i + "] " + matrix[adjacentRow][i] + " | [" + i + ", " + adjacentColumn + "]: " + matrix[i][adjacentColumn]);
                }

                int temp = matrix[adjacentRow][i];
                matrix[adjacentRow++][i] = matrix[i][adjacentColumn];
                matrix[i][adjacentColumn++] = temp;
            }
        }
        if (isTest) {
            print("----------------------------\nupdated:");
        }
    }

    private void swap(int column) {
        int firstRow = 0;
        int lastRow = n - 1;

        while (firstRow < lastRow) {
            int temp = matrix[firstRow][column];
            matrix[firstRow++][column] = matrix[lastRow][column];
            matrix[lastRow--][column] = temp;
        }
    }

    private void print(String s) {
        System.out.println(s);
        for (int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("----------------------------");
    }
}
