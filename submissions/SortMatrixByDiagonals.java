// Question: https://leetcode.com/problems/sort-matrix-by-diagonals/description/

class SortMatrixByDiagonals {
    public int[][] sortMatrix(int[][] grid) {
        boolean isTest = false;
        int totalColumns = grid[0].length;
        int totalRows = grid.length;

        if (isTest) {
            display("before, grid:", grid);
        }

        for (int i = 0; i < totalRows; i++) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            int column = 0;
            int row = i;

            while (row < totalRows && column < totalColumns) {
                maxHeap.offer(grid[row++][column++]);
            }
            grid = update("non-increasing", i, maxHeap, grid);
        }

        for (int i = 1; i < totalColumns; i++) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int column = i;
            int row = 0;

            while (row < totalRows && column < totalColumns) {
                minHeap.offer(grid[row++][column++]);
            }
            grid = update("non-decreasing", i, minHeap, grid);
        }

        if (isTest) {
            display("after, grid:", grid);
        }

        return grid;
    }

    private int[][] update(String diagonalType, int i, PriorityQueue<Integer> heap, int[][] grid) {
        int column = 0;
        int row = i;

        if (diagonalType.equals("non-increasing")) {
            while (row < grid.length && column < grid[0].length) {
                grid[row++][column++] = heap.poll();
            }

        } else {
            column = i;
            row = 0;
            while (row < grid.length && column < grid[0].length) {
                grid[row++][column++] = heap.poll();
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