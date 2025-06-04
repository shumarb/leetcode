// Question: https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/

class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        boolean isTest = false;
        if (isTest) {
            display(matrix);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int number = matrix[i][j];
                if (number == findMinimumInRow(i, matrix) && number == findMaximumInColumn(j, matrix)) {
                    luckyNumbers.add(number);
                }
            }
        }
        return luckyNumbers;
    }

    private int findMaximumInColumn(int columnNumber, int[][] matrix) {
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            maximum = Math.max(maximum, matrix[i][columnNumber]);
        }
        return maximum;
    }

    private int findMinimumInRow(int rowNumber, int[][] matrix) {
        int minimum = Integer.MAX_VALUE;
        int[] row = matrix[rowNumber];
        for (int element: row) {
            minimum = Math.min(element, minimum);
        }
        return minimum;
    }

    private void display(int[][] matrix) {
        System.out.println("matrix:");
        for (int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------------------------------------------------------");
    }
}