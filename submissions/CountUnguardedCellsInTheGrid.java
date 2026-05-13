// Question: https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/

class CountUnguardedCellsInTheGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        boolean isTest = false;
        int[][] grid = new int[m][n];
        int result = m * n;

        for (int[] guard: guards) {
            grid[guard[0]][guard[1]] = 1;
            result--;
        }
        for (int[] wall: walls) {
            grid[wall[0]][wall[1]] = -1;
            result--;
        }
        if (isTest) {
            print("before:", grid, result);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int nextColumn = j + 1;
                    int nextRow = i + 1;

                    while (nextRow < m) {
                        if (grid[nextRow][j] == 0 || grid[nextRow][j] == 2) {
                            if (grid[nextRow][j] == 0) {
                                result--;
                            }
                            grid[nextRow++][j] = 2;

                        } else {
                            break;
                        }
                    }

                    while (nextColumn < n) {
                        if (grid[i][nextColumn] == 0 || grid[i][nextColumn] == 2) {
                            if (grid[i][nextColumn] == 0) {
                                result--;
                            }
                            grid[i][nextColumn++] = 2;

                        } else {
                            break;
                        }
                    }

                    nextRow = i - 1;
                    while (nextRow >= 0) {
                        if (grid[nextRow][j] == 0 || grid[nextRow][j] == 2) {
                            if (grid[nextRow][j] == 0) {
                                result--;
                            }
                            grid[nextRow--][j] = 2;

                        } else {
                            break;
                        }
                    }

                    nextColumn = j - 1;
                    while (nextColumn >= 0) {
                        if (grid[i][nextColumn] == 0 || grid[i][nextColumn] == 2) {
                            if (grid[i][nextColumn] == 0) {
                                result--;
                            }
                            grid[i][nextColumn--] = 2;

                        } else {
                            break;
                        }
                    }
                }
            }
        }
        if (isTest) {
            print("after:", grid, result);
        }

        return result;
    }

    private void print(String s, int[][] grid, int result) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\nresult: " + result);
        System.out.println("--------------------------------------");
    }
}
