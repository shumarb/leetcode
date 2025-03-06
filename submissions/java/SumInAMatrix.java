// Question: https://leetcode.com/problems/sum-in-a-matrix/description/

class SumInAMatrix {
    public int matrixSum(int[][] nums) {
        int highestValue = 0;
        boolean isTest = false;

        for (int[] row: nums) {
            Arrays.sort(row);
        }
        if (isTest) {
            System.out.println("sorted nums:");
            for (int[] row: nums) {
                System.out.println(" * " + Arrays.toString(row));
            }
            System.out.println("-------------------------------------------------");
        }

        for (int i = 0; i < nums[0].length; i++) {
            int maximum = Integer.MIN_VALUE;
            for (int[] row: nums) {
                maximum = Math.max(maximum, row[i]);
            }
            highestValue += maximum;
        }

        return highestValue;
    }
}