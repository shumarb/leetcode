// Question: https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/description/

class MatrixSimilarityAfterCyclicShifts {
    public boolean areSimilar(int[][] mat, int k) {
        boolean isTest = false;
        int[][] grid = mat.clone();
        int m = mat.length;
        int n = mat[0].length;
        k %= n;

        for (int i = 0; i < grid.length; i++) {
            if (i % 2 == 0) {
                grid[i] = rotate(grid[i], 'l', k);
            } else {
                grid[i] = rotate(grid[i], 'r', k);
            }
        }
        if (isTest) {
            print("mat:", mat);
            print("grid:", grid);
        }
        for (int i = 0; i < mat.length; i++) {
            int[] first = mat[i];
            int[] second = grid[i];
            if (isTest) {
                System.out.println(" * compare | first: " + Arrays.toString(first) + ", second: " + Arrays.toString(second));
            }
            for (int j = 0; j < n; j++) {
                if (first[j] != second[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private void print(String s, int[][] grid) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------------------------------");
    }

    private int[] rotate(int[] arr, char option, int k) {
        int n = arr.length;
        int[] result = new int[n];
        k %= n;
        for (int i = 0; i < n; i++) {
            if (option == 'r') {
                result[(i + k) % n] = arr[i];
            } else {
                result[(i - k + n) % n] = arr[i];
            }
        }

        return result;
    }
}