// Question: https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/

class MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        boolean isTest = false;
        int n = rocks.length;
        int result = 0;
        int[] remainder = new int[n];

        for (int i = 0; i < n; i++) {
            remainder[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remainder);
        if (isTest) {
            System.out.println("additionalRocks: " + additionalRocks + "\ncapacity:  " + Arrays.toString(capacity) + "\nrocks:     " + Arrays.toString(rocks) + "\nremainder: " + Arrays.toString(remainder) + "\n-----------------------------------------------------");
        }

        for (int i = 0; i < n; i++) {
            int countRocksToAdd = remainder[i];

            if (additionalRocks - countRocksToAdd >= 0) {
                if (isTest) {
                    System.out.println(" * full: " + i + " | countRocksToAdd: " + countRocksToAdd + " | balance rocks: " + additionalRocks);
                }
                additionalRocks -= countRocksToAdd;
                result++;

            } else {
                break;
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
