// Question: https://leetcode.com/problems/sort-the-matrix-diagonally/description/

class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        boolean isTest = false;
        int totalColumns = mat[0].length;
        int totalRows = mat.length;

        if (isTest) {
            display("before, mat:", mat);
        }

        for (int i = 0; i < totalRows; i++) {
            List<Integer> elements = new ArrayList<>();
            int row = i;
            int column = 0;
            while (row < totalRows && column < totalColumns) {
                elements.add(mat[row++][column++]);
            }
            Collections.sort(elements);
            mat = update(i, elements, mat, "first");
        }

        for (int i = 1; i < totalColumns; i++) {
            List<Integer> elements = new ArrayList<>();
            int row = 0;
            int column = i;
            while (row < totalRows && column < totalColumns) {
                elements.add(mat[row++][column++]);
            }
            Collections.sort(elements);
            mat = update(i, elements, mat, "second");
        }

        if (isTest) {
            display("after, mat:", mat);
        }

        return mat;
    }

    private int[][] update(int i, List<Integer> elements, int[][] mat, String diagonalType) {
        int k = 0;
        int row = i;
        int column = 0;

        if (diagonalType.equals("first")) {
            while (row < mat.length && column < mat[0].length) {
                mat[row++][column++] = elements.get(k++);
            }

        } else {
            row = 0;
            column = i;
            while (row < mat.length && column < mat[0].length) {
                mat[row++][column++] = elements.get(k++);
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