// Question: https://leetcode.com/problems/first-completely-painted-row-or-column/description/

class FirstCompletelyPaintedRowOrColumn {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        boolean isTest = false;
        int m = mat.length;
        int n = mat[0].length;
        int[] columnMap;
        int[] countPaintedColumns = new int[n];
        int[] countPaintedRows = new int[m];
        int[] rowMap;

        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                largest = Math.max(largest, mat[i][j]);
            }
        }

        columnMap = new int[largest + 1];
        rowMap = new int[largest + 1];
        Arrays.fill(columnMap, -1);
        Arrays.fill(rowMap, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int element = mat[i][j];
                columnMap[element] = j;
                rowMap[element] = i;
            }
        }
        if (isTest) {
            System.out.println("columnMap: " + Arrays.toString(columnMap) + "\nrowMap:    " + Arrays.toString(rowMap));
        }

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int column = columnMap[element];
            int row = rowMap[element];
            if (++countPaintedColumns[column] == m || ++countPaintedRows[row] == n) {
                return i;
            }
        }

        return -1;
    }
}