// Question: https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/

class DetermineWhetherMatrixCanBeObtainedByRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean isTest = false;

        if (isValid(mat, target)) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            mat = rotate(mat);
            if (isTest) {
                print("updated mat:", mat, "target:", target);
            }
            if (isValid(mat, target)) {
                return true;
            }
        }

        return false;
    }

    private boolean isValid(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            if (!Arrays.equals(mat[i], target[i])) {
                return false;
            }
        }

        return true;
    }

    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - 1 - i] = mat[i][j];
            }
        }

        return result;
    }

    private void print(String s1, int[][] mat, String s2, int[][] target) {
        System.out.println(s1);
        for (int[] row: mat) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\n" + s2);
        for (int[] row: target) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------------------------");
    }
}