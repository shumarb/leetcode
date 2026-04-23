// Question: https://leetcode.com/problems/difference-of-number-of-distinct-values-on-diagonals/description/

class DifferenceOfNumberOfDistinctValuesOnDiagonals {
    private boolean isTest;

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] answer = new int[m][n];
        isTest = false;

        if (isTest) {
            print("grid:", grid);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int element = grid[i][j];
                answer[i][j] = computeDifferenceOfDistinctValues(element, i, j, grid);
            }
        }
        if (isTest) {
            print("------------------------------------------------------------------------\nanswer:", answer);
        }

        return answer;
    }

    private int computeDifferenceOfDistinctValues(int key, int row, int column, int[][] grid) {
        boolean[] isPresent = new boolean[51];
        int distinctValuesLeftAbove = 0;
        int distinctValuesRightBelow = 0;
        int i = row - 1;
        int j = column - 1;
        int result = 0;

        while (i >= 0 && j >= 0) {
            int current = grid[i--][j--];
            if (isPresent[current]) {
                continue;
            }
            distinctValuesLeftAbove++;
            isPresent[current] = true;
        }

        i = row + 1;
        j = column + 1;
        isPresent = new boolean[51];
        while (i < grid.length && j < grid[0].length) {
            int current = grid[i++][j++];
            if (isPresent[current]) {
                continue;
            }
            distinctValuesRightBelow++;
            isPresent[current] = true;
        }

        if (isTest) {
            System.out.println(" * [" + row + ", " + column + "] | e: " + key + " | distinctValuesLeftAbove: " + distinctValuesLeftAbove + ", distinctValuesRightBelow: " + distinctValuesRightBelow);
        }

        return Math.abs(distinctValuesLeftAbove - distinctValuesRightBelow);
    }

    private void print(String s, int[][] grid) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------------------------------------------------------------");
    }
}
