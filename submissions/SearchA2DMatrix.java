// Question: https://leetcode.com/problems/search-a-2d-matrix/description/

class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         1.  Edge case: Target smaller than first element of first row,
             hence it is not in matrix.
         */
        if (target < matrix[0][0]) {
            return false;

        /**
            2.  Edge case: target is either first element of first row of matrix,
                or last element of last row of matrix.
         */
        } else if (target == matrix[0][0] || target == matrix[matrix.length - 1][matrix[0].length - 1]) {
            return true;
        }

        boolean isTest = false;
        int first = 0;
        int last = matrix.length - 1;
        int[] targetArray = null;

        if (isTest) {
            System.out.println("matrix:");
            for (int[] row: matrix) {
                System.out.println(" * " + Arrays.toString(row));
            }
            System.out.println("------------------------------------------------------");
        }

        while (first <= last) {
            int mid = first + (last - first) / 2;
            int[] midArray = matrix[mid];
            if (target >= midArray[0] && target <= midArray[midArray.length - 1]) {
                if (target == midArray[0] || target == midArray[midArray.length - 1]) {
                    return true;
                }
                targetArray = midArray;
                break;
            } else if (target < midArray[0]) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        if (isTest) {
            System.out.println("target: " + target);
            System.out.println("targetArray: " + Arrays.toString(targetArray));
        }

        return targetArray == null ? false : Arrays.binarySearch(targetArray, target) >= 0;
    }
}