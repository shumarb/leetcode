// Question: https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/description/

class MinimumOperationsToMakeColumnsStrictlyIncreasing {
    public int minimumOperations(int[][] grid) {
        boolean isTest = false;
        int count = 0;
        int numRow = grid.length;
        int numColumn = grid[0].length;

        for (int i = 0; i < numColumn; i++) {
            List<Integer> column = new ArrayList<>();
            for (int j = 0; j < numRow; j++) {
                column.add(grid[j][i]);
            }
            if (isTest) {
                System.out.println("column: " + column);
            }
            for (int k = 1; k < column.size(); k++) {
                int current = column.get(k);
                int previous = column.get(k - 1);
                while (current <= previous) {
                    if (isTest) {
                        System.out.println(" * current: " + current + ", previous: " + previous);
                    }
                    column.set(k, current + 1);
                    current = current + 1;
                    count++;
                }
            }
        }
        return count;
    }
}