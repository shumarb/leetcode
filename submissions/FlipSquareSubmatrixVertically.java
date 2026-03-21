// Question: https://leetcode.com/problems/flip-square-submatrix-vertically/description/

class FlipSquareSubmatrixVertically {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        boolean isTest = false;

        if (isTest) {
            display("before, grid:", grid);
        }
        for (int j = y; j < y + k; j++) {
            int top = x;
            int bottom = x + k - 1;
            while (top < bottom) {
                int temp = grid[top][j];
                grid[top++][j] = grid[bottom][j];
                grid[bottom--][j] = temp;
            }
        }
        if (isTest) {
            display("after, grid:", grid);
        }

        return grid;
    }

    private void display(String s, int[][] grid) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------------------------------------------------");
    }
}
