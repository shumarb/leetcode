// Question: https://leetcode.com/problems/sort-the-matrix-diagonally/description/

class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        List<Integer> elements = new ArrayList<>();
        boolean isTest = false;
        int column;
        int row;
        int totalColumns = mat[0].length;
        int totalRows = mat.length;

        if (isTest) {
            display("before, mat:", mat);
        }

        for (int i = 0; i < totalRows; i++) {
            elements.clear();
            column = 0;
            row = i;
            while (row < totalRows && column < totalColumns) {
                elements.add(mat[row++][column++]);
            }
            mat = update(i, elements, mat, "first");
        }

        for (int i = 1; i < totalColumns; i++) {
            elements.clear();
            row = 0;
            column = i;
            while (row < totalRows && column < totalColumns) {
                elements.add(mat[row++][column++]);
            }
            mat = update(i, elements, mat, "second");
        }

        if (isTest) {
            display("after, mat:", mat);
        }

        return mat;
    }

    private int[][] update(int i, List<Integer> elements, int[][] mat, String diagonalType) {
        int[] frequency;
        int column = 0;
        int largest = 0;
        int row = i;

        for (int number: elements) {
            largest = Math.max(largest, number);
        }
        frequency = new int[largest + 1];
        for (int number: elements) {
            frequency[number]++;
        }

        if (diagonalType.equals("second")) {
            column = i;
            row = 0;
        }
        for (int j = 0; j <= largest; j++) {
            while (frequency[j]-- > 0) {
                mat[row++][column++] = j;
            }
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