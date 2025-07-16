// Question: https://leetcode.com/problems/sum-of-matrix-after-queries/description/

class SumOfMatrixAfterQueries {
    public long matrixSumQueries(int n, int[][] queries) {
        boolean[] isRowSeen = new boolean[n];
        boolean[] isColumnSeen = new boolean[n];
        int remainingUnaffectedRows = n;
        int remainingUnaffectedColumns = n;
        long sum = 0;

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] query = queries[i];
            int type = query[0];
            int index = query[1];
            int val = query[2];

            if (type == 0) {
                if (!isRowSeen[index]) {
                    sum += val * remainingUnaffectedColumns;
                    isRowSeen[index] = true;
                    remainingUnaffectedRows--;
                }
            } else {
                if (!isColumnSeen[index]) {
                    sum += val * remainingUnaffectedRows;
                    isColumnSeen[index] = true;
                    remainingUnaffectedColumns--;
                }
            }

        }

        return sum;
    }
}