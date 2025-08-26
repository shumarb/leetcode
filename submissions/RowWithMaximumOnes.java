// Question: https://leetcode.com/problems/row-with-maximum-ones/description/

class RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int index = 0;
        int maximum = 0;

        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int current = 0;

            for (int number: row) {
                if (number == 1) {
                    current++;
                }
            }

            if (current > maximum) {
                index = i;
                maximum = current;
            }
        }

        return new int[] {index, maximum};
    }
}