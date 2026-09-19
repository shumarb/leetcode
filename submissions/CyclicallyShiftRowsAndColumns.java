// Question: https://leetcode.com/problems/cyclically-shift-rows-and-columns/description/

class CyclicallyShiftRowsAndColumns class Solution {
    private int[][] grid;
    private int n;

    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        boolean isTest = false;
        this.grid = grid;
        this.n = n;

        if (isTest) {
            print("n: " + n + "\n\ninitial:", grid);
        }
        for (int i = 0; i < n; i++) {
            int k = rowShift[i];
            if (isTest) {
                System.out.println(" * row " + i + ", shift left by " + k);
            }

            if (k > 0) {
                shiftRow(i, k % n);
            }
            if (isTest) {
                print("\nafter shift:", grid);
            }
        }
        for (int j = 0; j < n; j++) {
            int k = colShift[j];
            if (isTest) {
                System.out.println(" * col " + j + ", shift up by " + k);
            }

            if (k > 0) {
                shiftColumn(j, k % n);
            }
            if (isTest) {
                print("\nafter shift:", grid);
            }
        }
        if (isTest) {
            print("final:", grid);
        }

        return grid;
    }

    private void shiftRow(int row, int k) {
        int[] updated = new int[n];

        for (int j = 0; j < n; j++) {
            int newIndex = (j - k + n) % n;
            updated[newIndex] = grid[row][j];
        }

        grid[row] = updated;
    }

    private void shiftColumn(int column, int k) {
        int[] updated = new int[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i - k + n) % n;
            updated[newIndex] = grid[i][column];
        }

        for (int i = 0; i < n; i++) {
            grid[i][column] = updated[i];
        }
    }

    private void print(String s, int[][] grid) {
        System.out.println(s);
        for (int[] e: grid) {
            System.out.println(Arrays.toString(e));
        }
        System.out.println("---------------------------------");
    }
}
