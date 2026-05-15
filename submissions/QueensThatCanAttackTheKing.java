// Question: https://leetcode.com/problems/queens-that-can-attack-the-king/description/

class QueensThatCanAttackTheKing {
    private List<List<Integer>> result;
    private int[][] grid;
    private int kingColumn;
    private int kingRow;
    private int m;
    private int n;

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean isTest = false;
        kingColumn = king[1];
        kingRow = king[0];
        m = 8;
        n = 8;
        grid = new int[m][n];
        result = new ArrayList<>();

        grid[kingRow][kingColumn] = 1;
        for (int[] queen: queens) {
            grid[queen[0]][queen[1]] = 2;
        }
        if (isTest) {
            System.out.println("grid:");
            for (int[] row: grid) {
                System.out.println(Arrays.toString(row));
            }
        }

        goLeftDiagonal();
        goRightDiagonal();
        goVertical();
        goHorizontal();
        if (isTest) {
            System.out.println("------------------------------\nresult:");
            for (List<Integer> coordinate: result) {
                System.out.println(" * " + coordinate);
            }
        }

        return result;
    }

    private void goRightDiagonal() {
        int column = kingColumn + 1;
        int row = kingRow - 1;

        while (row >= 0 && column < n) {
            if (grid[row][column] == 2) {
                result.add(List.of(row, column));
                break;
            }
            row--;
            column++;
        }

        column = kingColumn - 1;
        row = kingRow + 1;
        while (row < m && column >= 0) {
            if (grid[row][column] == 2) {
                result.add(List.of(row, column));
                break;
            }
            row++;
            column--;
        }
    }

    private void goLeftDiagonal() {
        int column = kingColumn - 1;
        int row = kingRow - 1;

        while (row >= 0 && column >= 0) {
            if (grid[row][column] == 2) {
                result.add(List.of(row, column));
                break;
            }
            row--;
            column--;
        }

        column = kingColumn + 1;
        row = kingRow + 1;
        while (row < m && column < n) {
            if (grid[row][column] == 2) {
                result.add(List.of(row, column));
                break;
            }
            row++;
            column++;
        }
    }

    private void goHorizontal() {
        int column = kingColumn - 1;

        while (column >= 0) {
            if (grid[kingRow][column] == 2) {
                result.add(List.of(kingRow, column));
                break;
            }
            column--;
        }

        column = kingColumn + 1;
        while (column < n) {
            if (grid[kingRow][column] == 2) {
                result.add(List.of(kingRow, column));
                break;
            }
            column++;
        }
    }

    private void goVertical() {
        int row = kingRow - 1;

        while (row >= 0) {
            if (grid[row][kingColumn] == 2) {
                result.add(List.of(row, kingColumn));
                break;
            }
            row--;
        }

        row = kingRow + 1;
        while (row < m) {
            if (grid[row][kingColumn] == 2) {
                result.add(List.of(row, kingColumn));
                break;
            }
            row++;
        }
    }
}
