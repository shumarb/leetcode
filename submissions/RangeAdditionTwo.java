// Question:

class RangeAdditionTwo {
    public int maxCount(int m, int n, int[][] ops) {
        int minCol = n;
        int minRow = m;

        for (int[] op: ops) {
            minCol = Math.min(minCol, op[1]);
            minRow = Math.min(minRow, op[0]);
        }

        return minCol * minRow;
    }
}