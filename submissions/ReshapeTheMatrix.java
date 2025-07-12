// Question: https://leetcode.com/problems/reshape-the-matrix/description/

class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int matColumns = mat[0].length;
        int matRows = mat.length;

        if (matRows * matColumns != r * c) {
            return mat;
        }

        boolean isTest = false;
        int[][] result = new int[r][c];
        int column = 0;
        int row = 0;

        for (int i = 0; i < matRows; i++) {
            for (int j = 0; j < matColumns; j++) {
                if (column == c) {
                    column = 0;
                    row++;
                }
                result[row][column] = mat[i][j];
                column++;
            }
        }
        if (isTest) {
            display("mat:", mat);
            display("result:", result);
        }

        return result;
    }

    private void display(String sentence, int[][] matrix) {
        System.out.println(sentence);
        for (int[] row: matrix) {
            System.out.println(" * " + Arrays.toString(row));
        }
        System.out.println("-----------------------------------------------");
    }
}