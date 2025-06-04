// Question: https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/description/

import java.util.Arrays;

class CheckIfEveryRowAndColumnContainsAllNumbers {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0] >= 1 && matrix[0][0] <= n;
        }

        boolean isTest = false;
        for (int[] rowArr: matrix) {
            if (isTest) {
                System.out.println("rowArr: " + Arrays.toString(rowArr));
            }
            if (!isValid(rowArr, n)) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            int k = 0;
            int[] colArr = new int[n];
            for (int j = 0; j < n; j++) {
                colArr[k++] = matrix[j][i];
            }
            if (isTest) {
                System.out.println("colArr: " + Arrays.toString(colArr));
            }
            if (!isValid(colArr, n)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(int[] arr, int n) {
        int[] freqArr = new int[n + 1];
        for (int element: arr) {
            if (element >= 1 && element <= n) {
                freqArr[element]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (freqArr[i] == 0) {
                return false;
            }
        }
        return true;
    }
}