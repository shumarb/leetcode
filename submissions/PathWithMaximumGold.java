// Question: https://leetcode.com/problems/path-with-maximum-gold/description/

class PathWithMaximumGold {
    private List<int[]> path;
    private boolean[][] isVisited;
    private boolean isTest;
    private int[][] grid;
    private int m;
    private int n;
    private int sum;
    private int result;

    public int getMaximumGold(int[][] grid) {
        isTest = false;
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];
        path = new ArrayList<>();
        result = 0;
        this.grid = grid;

        if (isTest) {
            System.out.println("grid: ");
            for (int[] row: grid) {
                System.out.println(Arrays.toString(row));
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !isVisited[i][j]) {
                    dfs(i, j, 0);
                }
            }
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private void dfs(int row, int column, int sum) {
        if (column < 0 || column >= n || row < 0 || row >= m || isVisited[row][column] || grid[row][column] == 0) {
            return;
        }

        sum += grid[row][column];

        result = Math.max(result, sum);

        path.add(new int[] {row, column});
        isVisited[row][column] = true;

        if (isTest) {
            System.out.print("------------------------------------------------------------------------------\npath: ");
            for (int[] e: path) {
                System.out.print(Arrays.toString(e) + " ");
            }
            System.out.println(" | sum: " + sum + ", result: " + result);
        }

        dfs(row - 1, column, sum);
        dfs(row + 1, column, sum);
        dfs(row, column - 1, sum);
        dfs(row, column + 1, sum);

        isVisited[row][column] = false;
        path.removeLast();
    }
}
