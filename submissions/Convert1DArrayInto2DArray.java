// Question: https://leetcode.com/problems/convert-1d-array-into-2d-array/description/

class Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }

        boolean isTest = false;
        int k = 0;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            result[i] = Arrays.copyOfRange(original, i * n, i * n + n);
        }
        if (isTest) {
            System.out.println("original: " + Arrays.toString(original) + "\n");
            System.out.println("result:");
            for (int[] row: result) {
                System.out.println(Arrays.toString(row));
            }
        }

        return result;
    }
}