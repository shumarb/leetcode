// Question: https://leetcode.com/problems/row-with-maximum-ones/description/

class RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] result = new int[2];

        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int element: mat[i]) {
                sum += element;
            }
            if (sum > result[1]) {
                result[0] = i;
                result[1] = sum;
            }
        }

        return result;
    }
}