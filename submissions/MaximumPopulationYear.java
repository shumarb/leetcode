// Question: https://leetcode.com/problems/maximum-population-year/description/

class MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        boolean isTest = false;
        int[] count = new int[101];
        int maximum;
        int result;

        for (int[] log: logs) {
            count[log[0] - 1950]++;
            count[log[1] - 1950]--;
        }
        maximum = count[0];
        result = 1950;

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
            if (count[i] > maximum) {
                maximum = count[i];
                result = i + 1950;
            }
        }
        if (isTest) {
            System.out.println("count: " + Arrays.toString(count) + "\nmaximum: " + maximum + "\nresult: " + result);
        }

        return result;
    }
}
