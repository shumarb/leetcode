// Question: https://leetcode.com/problems/find-a-peak-element-ii/description/

class FindAPeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        boolean isTest = false;
        int m = mat.length;
        int n = mat[0].length;

        if (isTest) {
            System.out.println("mat:");
            for (int[] row: mat) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("------------------------------------------------------------------");
        }

        if (m == 1 && n == 1) {
            return new int[] {0, 0};
        }

        int leftColumn = 0;
        int rightColumn = n - 1;

        while (leftColumn <= rightColumn) {
            int midColumn = leftColumn + (rightColumn - leftColumn) / 2;

            int maximumRow = 0;
            for (int i = 1; i < m; i++) {
                if (mat[i][midColumn] > mat[maximumRow][midColumn]) {
                    maximumRow = i;
                }
            }

            int leftValue = midColumn - 1 >= 0 ? mat[maximumRow][midColumn - 1] : -1;
            int rightValue = midColumn + 1 < n ? mat[maximumRow][midColumn + 1] : -1;

            if (isTest) {
                System.out.println("columns | leftColumn: " + leftColumn + " | rightColumn: " + rightColumn + " | midColumn: " + midColumn);
                System.out.println(" * maximum element in row: " + mat[maximumRow][midColumn] + " | leftValue: " + leftValue + " | rightValue: " + rightValue + "\n");
            }
            if (mat[maximumRow][midColumn] > leftValue && mat[maximumRow][midColumn] > rightValue) {
                return new int[] {maximumRow, midColumn};
            }

            if (leftValue > mat[maximumRow][midColumn]) {
                rightColumn = midColumn - 1;

            } else {
                leftColumn = midColumn + 1;
            }
        }

        return new int[] {-1, -1};
    }
}
