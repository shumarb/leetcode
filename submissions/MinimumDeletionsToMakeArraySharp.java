// Question: https://leetcode.com/problems/minimum-deletions-to-make-array-sharp/description/

class MinimumDeletionsToMakeArraySharp {
    public int[] lastVisitedCell(char[][] grid) {
        int[] result = new int[] {0, 0};
        int currentColumn = 0;
        int currentRow = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        boolean isTest = false;

        if (isTest) {
            System.out.println("grid:");
            for (char[] row: grid) {
                System.out.println(Arrays.toString(row));
            }
            System.out.print("---------------------------------------------");
        }

        while (!isVisited[currentRow][currentColumn]) {
            isVisited[currentRow][currentColumn] = true;
            result[0] = currentRow;
            result[1] = currentColumn;

            char c = grid[currentRow][currentColumn];
            int nextColumn = currentColumn;
            int nextRow = currentRow;

            if (c == 'R') {
                nextColumn++;

            } else if (c == 'L') {
                nextColumn--;

            } else if (c == 'U') {
                nextRow--;

            } else if (c == 'D') {
                nextRow++;
            }

            if (isTest) {
                System.out.println("\nc: " + c + "\n * current cell: " + Arrays.toString(result) + "\n * next cell: " + Arrays.toString(new int[] {nextRow, nextColumn}));
            }

            if (nextColumn < 0 || nextColumn >= n || nextRow < 0 || nextRow >= m || isVisited[nextRow][nextColumn]) {
                if (isTest) {
                    System.out.println(" ** invalid next cell, final result: " + Arrays.toString(result));
                }
                break;
            }

            currentColumn = nextColumn;
            currentRow = nextRow;
        }
        if (isTest) {
            System.out.println("---------------------------------------------\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}
