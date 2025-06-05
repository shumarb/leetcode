// Question: https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/

class SpecialPositionsInABinaryMatrix {
    private boolean isTest = false;

    public int numSpecial(int[][] mat) {
        int count = 0;

        if (isTest) {
            display(mat);
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && isSpecial(i, j, mat)) {
                    if (isTest) {
                        System.out.println(" * counted: (" + i + ", " + j + ")");
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private void display(int[][] mat) {
        System.out.println("matrix:");
        for (int[] row: mat) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------------------------------------------------------------");
    }

    private boolean isSpecial(int rowNumber, int columnNumber, int[][] mat) {
        if (isTest) {
            System.out.println("checking | row: " + rowNumber + ", col: " + columnNumber);
        }

        int[] row = mat[rowNumber];
        for (int i = 0; i < row.length; i++) {
            if (i != columnNumber && row[i] != 0) {
                return false;
            }
        }

        for (int j = 0; j < mat.length; j++) {
            if (j != rowNumber && mat[j][columnNumber] != 0) {
                return false;
            }
        }

        return true;
    }
}