// Question: https://leetcode.com/problems/row-with-maximum-ones/description/

class RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int index = 0;
        int maximumCount = 0;
        boolean isTest = false;
        for (int i = 0; i < mat.length; i++) {
            if (isTest) {
                System.out.println("row: " + Arrays.toString(mat[i]));
            }
            int currentCount = countOnes(mat[i]);
            if (currentCount > maximumCount) {
                maximumCount = currentCount;
                index = i;
            }
        }
        return new int[] {index, maximumCount};
    }

    private int countOnes(int[] arr) {
        int count = 0;
        for (int element: arr) {
            if (element == 1) {
                count++;
            }
        }
        return count;
    }
}