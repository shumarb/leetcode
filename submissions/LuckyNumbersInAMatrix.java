// Question: https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/

class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        boolean isTest = false;
        boolean[] isNumberChecked;
        int largest = Integer.MIN_VALUE;

        for (int[] row: matrix) {
            for (int number: row) {
                largest = Math.max(largest, number);
            }
        }
        isNumberChecked = new boolean[largest + 1];
        if (isTest) {
            System.out.println("matrix:");
            for (int[] row: matrix) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("--------------------------------------------------------");
        }

        for (int[] entry: matrix) {
            int minimum = entry[0];
            for (int number: entry) {
                minimum = Math.min(minimum, number);
            }
            isNumberChecked[minimum] = true;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int maximum = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                maximum = Math.max(maximum, matrix[j][i]);
            }
            if (isNumberChecked[maximum]) {
                result.add(maximum);
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}