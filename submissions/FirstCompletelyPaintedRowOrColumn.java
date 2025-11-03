// Question: https://leetcode.com/problems/first-completely-painted-row-or-column/description/

class FirstCompletelyPaintedRowOrColumn {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> columnMap = new HashMap<>();
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> paintedColumn = new HashMap<>();
        Map<Integer, Set<Integer>> paintedRow = new HashMap<>();
        boolean isTest = false;
        int m = mat.length;
        int n = mat[0].length;
        int result = -1;

        /**
         4 3 5
         1 2 6
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int element = mat[i][j];
                columnMap.put(element, j);
                rowMap.put(element, i);
            }
        }

        /**
         4* 3 5*
         1* 2 6
         */
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int elementColumn = columnMap.get(element);
            int elementRow = rowMap.get(element);

            if (isTest) {
                System.out.println("-------------------------------------------------");
                System.out.println("element: " + element + "\n * elementRow: " + elementRow + "\n * elementColumn: " + elementColumn);
                System.out.println("\nbefore\n * paintedRow: " + paintedRow + "\n * paintedColumn: " + paintedColumn);
            }
            if (!paintedRow.containsKey(elementRow)) {
                Set<Integer> set = new HashSet<>();
                set.add(element);
                paintedRow.put(elementRow, set);
            } else {
                Set<Integer> set = paintedRow.get(elementRow);
                set.add(element);
                paintedRow.put(elementRow, set);
            }

            if (!paintedColumn.containsKey(elementColumn)) {
                Set<Integer> set = new HashSet<>();
                set.add(element);
                paintedColumn.put(elementColumn, set);
            } else {
                Set<Integer> set = paintedColumn.get(elementColumn);
                set.add(element);
                paintedColumn.put(elementColumn, set);
            }
            if (isTest) {
                System.out.println("\nafter\n * paintedRow: " + paintedRow + "\n * paintedColumn: " + paintedColumn);
            }

            if (paintedColumn.get(elementColumn).size() == m || paintedRow.get(elementRow).size() == n) {
                result = i;
                break;
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------------");
            System.out.println("columnMap: " + columnMap + "\nrowMap: " + rowMap);
            System.out.println("paintedRow: " + paintedRow + "\npaintedColumn: " + paintedColumn + "\nresult: " + result);
        }

        return result;
    }
}