// Question: https://leetcode.com/problems/sort-matrix-by-diagonals/description/

class SortMatrixByDiagonals {
    public int[][] sortMatrix(int[][] grid) {
        List<Integer> elements = new ArrayList<>();
        boolean isTest = false;
        int totalColumns = grid[0].length;
        int totalRows = grid.length;

        if (isTest) {
            display("before, grid:", grid);
        }

        for (int i = 0; i < totalRows; i++) {
            elements.clear();
            int column = 0;
            int row = i;

            while (row < totalRows && column < totalColumns) {
                elements.add(grid[row++][column++]);
            }
            grid = update("non-increasing", i, elements, grid);
        }

        for (int i = 1; i < totalColumns; i++) {
            elements.clear();
            int column = i;
            int row = 0;

            while (row < totalRows && column < totalColumns) {
                elements.add(grid[row++][column++]);
            }
            grid = update("non-decreasing", i, elements, grid);
        }

        if (isTest) {
            display("after, grid:", grid);
        }

        return grid;
    }

    private int[][] update(String diagonalType, int i, List<Integer> elements, int[][] grid) {
        int[] frequency = new int[200001];
        int column = 0;
        int row = i;

        for (int number: elements) {
            frequency[number + 100000]++;
        }

        if (diagonalType.equals("non-increasing")) {
            for (int j = frequency.length - 1; j >= 0; j--) {
                while (frequency[j]-- > 0) {
                    grid[row++][column++] = j - 100000;
                }
            }

        } else {
            column = i;
            row = 0;
            for (int j = 0; j < frequency.length; j++) {
                while (frequency[j]-- > 0) {
                    grid[row++][column++] = j - 100000;
                }
            }
        }

        return grid;
    }

    private void display(String s, int[][] grid) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(" * " + Arrays.toString(row));
        }
        System.out.println("----------------------------------------");
    }
}