// Question: https://leetcode.com/problems/transpose-matrix/description/

class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        boolean isTest = false;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[n][m];

        if (isTest) {
            display("matrix:", matrix);
        }
        for (int i = 0; i < n; i++) {
            int[] newRow = new int[m];
            for (int j = 0; j < m; j++) {
                newRow[j] = matrix[j][i];
            }
            if (isTest) {
                System.out.println("newRow: " + Arrays.toString(newRow));
            }
            result[i] = newRow;
        }
        if (isTest) {
            display("result:", result);
        }

        return result;
    }

    private void display(String sentence, int[][] matrix) {
        System.out.println(sentence);
        for (int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("----------------------------------------------------------");
    }
}