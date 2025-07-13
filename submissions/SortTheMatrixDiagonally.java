// Question: https://leetcode.com/problems/sort-the-matrix-diagonally/description/

class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        boolean isTest = false;
        int column;
        int row;
        int totalColumns = mat[0].length;
        int totalRows = mat.length;

        if (isTest) {
            display("before, mat:", mat);
        }

        for (int i = 0; i < totalRows; i++) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            column = 0;
            row = i;
            while (row < totalRows && column < totalColumns) {
                minHeap.add(mat[row++][column++]);
            }
            mat = update(i, minHeap, mat, "first");
        }

        for (int i = 1; i < totalColumns; i++) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            row = 0;
            column = i;
            while (row < totalRows && column < totalColumns) {
                minHeap.add(mat[row++][column++]);
            }
            mat = update(i, minHeap, mat, "second");
        }

        if (isTest) {
            display("after, mat:", mat);
        }

        return mat;
    }

    private int[][] update(int i, PriorityQueue<Integer> minHeap, int[][] mat, String diagonalType) {
        int column = 0;
        int row = i;

        if (diagonalType.equals("second")) {
            column = i;
            row = 0;
        }
        while (row < mat.length && column < mat[0].length) {
            mat[row++][column++] = minHeap.poll();
        }

        return mat;
    }

    private void display(String sentence, int[][] mat) {
        System.out.println(sentence);
        for (int[] row: mat) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------------------------------");
    }
}