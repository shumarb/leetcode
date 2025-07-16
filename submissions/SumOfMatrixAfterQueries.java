// Question: https://leetcode.com/problems/sum-of-matrix-after-queries/description/

class SumOfMatrixAfterQueries {
    public long matrixSumQueries(int n, int[][] queries) {
        boolean[] isColumnSeen = new boolean[n];
        boolean[] isRowSeen = new boolean[n];
        int remainingColumns = n;
        int remainingRows = n;
        long sum = 0;

        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int index = queries[i][1];
            int val = queries[i][2];

            if (type == 0) {
                if (!isRowSeen[index]) {
                    remainingRows--;
                    sum += val * remainingColumns;
                    isRowSeen[index] = true;
                }
            } else {
                if(!isColumnSeen[index]) {
                    remainingColumns--;
                    sum += val * remainingRows;
                    isColumnSeen[index] = true;
                }
            }
        }

        return sum;
    }
}