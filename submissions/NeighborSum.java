// Question: https://leetcode.com/problems/design-neighbor-sum-service/description/

class NeighborSum {
    private boolean isTest;
    private int[][] grid;
    private int[] xCoordinate;
    private int[] yCoordinate;

    public NeighborSum(int[][] grid) {
        isTest = false;
        this.grid = grid;
        populate();
    }

    private void populate() {
        int largest = Integer.MIN_VALUE;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                largest = Math.max(largest, grid[i][j]);
            }
        }
        xCoordinate = new int[largest + 1];
        yCoordinate = new int[largest + 1];
        Arrays.fill(xCoordinate, -1);
        Arrays.fill(yCoordinate, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int element = grid[i][j];
                xCoordinate[element] = i;
                yCoordinate[element] = j;
            }
        }
        if (isTest) {
            System.out.println("xCoordinate: " + Arrays.toString(xCoordinate));
            System.out.println("yCoordinate: " + Arrays.toString(yCoordinate));
        }
    }

    public int adjacentSum(int value) {
        if (xCoordinate[value] == -1 || yCoordinate[value] == -1) {
            return 0;
        }

        int n = grid.length;
        int c = yCoordinate[value];
        int r = xCoordinate[value];
        int sum = 0;

        if (r - 1 >= 0) {
            sum += grid[r - 1][c];
        }

        if (r + 1 < n) {
            sum += grid[r + 1][c];
        }

        if (c - 1 >= 0) {
            sum += grid[r][c - 1];
        }

        if (c + 1 < n) {
            sum += grid[r][c + 1];
        }

        return sum;
    }

    public int diagonalSum(int value) {
        if (xCoordinate[value] == -1 || yCoordinate[value] == -1) {
            return 0;
        }

        int n = grid.length;
        int c = yCoordinate[value];
        int r = xCoordinate[value];
        int sum = 0;

        if (r - 1 >= 0 && c - 1 >= 0) {
            sum += grid[r - 1][c - 1];
        }

        if (r - 1 >= 0 && c + 1 < n) {
            sum += grid[r - 1][c + 1];
        }

        if (r + 1 < n && c - 1 >= 0) {
            sum += grid[r + 1][c - 1];
        }

        if (r + 1 < n && c + 1 < n) {
            sum += grid[r + 1][c + 1];
        }

        return sum;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */