// Question: https://leetcode.com/problems/row-with-maximum-ones/description/

class RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maximum = 0;
        int index = 0;

        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int current = 0;

            for (int number: row) {
                if (number == 1) {
                    current++;
                }
            }

            if (current > maximum) {
                maximum = current;
                index = i;

            } else if (current == maximum && i < index) {
                index = i;
            }
        }

        return new int[] {index, maximum};
    }
}