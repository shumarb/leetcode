// Question: https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/

class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        boolean isTest = false;

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
            set.add(minimum);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int maximum = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                maximum = Math.max(maximum, matrix[j][i]);
            }
            if (set.contains(maximum)) {
                result.add(maximum);
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}