// Question: https://leetcode.com/problems/search-a-2d-matrix/description/

class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
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

        return targetArray == null ? false : isTargetFound(targetArray, target);
    }

    private boolean isTargetFound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}