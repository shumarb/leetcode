// Question: https://leetcode.com/problems/find-missing-and-repeated-values/description/

class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        boolean isTest = false;
        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        int maximum = findMaximum(grid);
        if (isTest) {
            System.out.println("maximum: " + maximum);
        }
        int[] numberFrequency = new int[maximum + 1];
        for (int[] row: grid) {
            for (int element: row) {
                numberFrequency[element]++;
            }
        }
        if (isTest) {
            System.out.println("numberFrequency: " + Arrays.toString(numberFrequency));
        }

        for (int i = 1; i < numberFrequency.length; i++) {
            if (numberFrequency[i] == 2) {
                ans[0] = i;
            }
            if (numberFrequency[i] == 0) {
                ans[1] = i;
            }
        }
        if (ans[1] == -1) {
            ans[1] = maximum + 1;
        }
        if (isTest) {
            System.out.println("ans: " + Arrays.toString(ans));
        }

        return ans;
    }

    private int findMaximum(int[][] grid) {
        int maximum = Integer.MIN_VALUE;
        for (int[] row: grid) {
            for (int element: row) {
                maximum = Math.max(maximum, element);
            }
        }
        return maximum;
    }
}