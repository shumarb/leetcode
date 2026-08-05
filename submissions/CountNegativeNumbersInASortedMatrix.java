// Question: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        boolean isTest = false;
        int result = 0;
        int n = grid[0].length;

        for (int[] row: grid) {
            int firstNegativeNumberIndex = -1;
            int left = 0;
            int right = n - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (row[mid] >= 0) {
                    left = mid + 1;
                } else {
                    firstNegativeNumberIndex = mid;
                    right = mid - 1;
                }
            }
            if (isTest) {
                System.out.println("row: " + Arrays.toString(row) + ", firstNegativeNumberIndex: " + firstNegativeNumberIndex + ", total negative numbers: " + (n - firstNegativeNumberIndex));
            }

            if (firstNegativeNumberIndex >= 0) {
                result += (n - firstNegativeNumberIndex);
            }
        }
        if (isTest) {
            System.out.println("------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
