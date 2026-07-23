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
            int next = i + 1;

            while (next < n) {
                if (isTest) {
                    System.out.println(" * [" + next + ", " + i + "]: " + matrix[next][i] + " | [" + i + ", " + next + "]: " + matrix[i][next]);
                }

                int temp = matrix[next][i];
                matrix[next][i] = matrix[i][next];
                matrix[i][next++] = temp;
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
