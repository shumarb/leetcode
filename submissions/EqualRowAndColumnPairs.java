// Question: https://leetcode.com/problems/equal-row-and-column-pairs/description/

class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int countPairs = 0;
        boolean isTest = false;
        List<int[]> rows = new ArrayList<>();
        List<int[]> columns = new ArrayList<>();

        for (int[] row: grid) {
            rows.add(row);
        }
        for (int i = 0; i < grid[0].length; i++) {
            int[] column = getColumn(grid, i);
            columns.add(column);
        }
        if (isTest) {
            display("rows:", rows);
            display("columns:", columns);
        }

        for (int[] row: rows) {
            for (int[] column: columns) {
                if (Arrays.equals(row, column)) {
                    countPairs++;
                }
            }
        }

        return countPairs;
    }

    private void display(String message, List<int[]> list) {
        System.out.println(message);
        for (int[] entry: list) {
            System.out.println(" * " + Arrays.toString(entry));
        }
    }

    private int[] getColumn(int[][] grid, int columnNumber) {
        int[] column = new int[grid.length];
        int j = 0;
        for (int i = 0; i < grid.length; i++) {
            column[j++] = grid[i][columnNumber];
        }
        return column;
    }
}