// Question: https://leetcode.com/problems/flip-square-submatrix-vertically/description/

class FillSquareSubmatrixVertically {
    private boolean isTest = false;

    private void update(int[][] grid, int x, int y, int k) {
        int top = x;
        int bottom = x + k - 1;
        if (isTest) {
            System.out.println("x: " + x + ", y: " + y + ", top: " + top + ", bottom: " + bottom);
            System.out.println("---------------------------------------------------------");
        }

        while (top < bottom) {
            int temp = grid[top][y];
            grid[top][y] = grid[bottom][y];
            grid[bottom][y] = temp;
            top++;
            bottom--;
        }
    }

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        if (isTest) {
            display("before:", grid);
        }
        for (int i = y; i < (y + k); i++) {
            update(grid, x, i, k);
        }
        if (isTest) {
            display("after:", grid);
        }

        return grid;
    }

    private void display(String sentence, int[][] grid) {
        System.out.println(sentence);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------------------------------------------------");
    }
}