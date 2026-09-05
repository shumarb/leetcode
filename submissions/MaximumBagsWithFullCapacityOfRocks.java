// Question: https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/

class MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int index = 0;
        int n = rocks.length;
        int result = 0;
        int[][] bags = new int[n][4];
        boolean isTest = false;

        if (isTest) {
            System.out.println("additionalRocks: " + additionalRocks + "\ncapacity: " + Arrays.toString(capacity) + "\nrocks:    " + Arrays.toString(rocks) + "\n");
        }
        for (int i = 0; i < n; i++) {
            bags[i] = new int[] {i, capacity[i], rocks[i], capacity[i] - rocks[i]};
        }
        if (isTest) {
            System.out.println("------------------------------------------------");
        }

        Arrays.sort(bags, (a, b) -> Integer.compare(a[3], b[3]));
        if (isTest) {
            System.out.println("bags: ");
            for (int[] e: bags) {
                System.out.println(" * id: " + e[0] + " | capacity: " + e[1] + " | rocks: " + e[2] + " | remainder: " + e[3]);
            }
            System.out.println("------------------------------------------------");
        }

        for (int i = 0; i < n && additionalRocks > 0; i++) {
            int[] bag = bags[i];
            if (bag[3] == 0) {
                if (isTest) {
                    System.out.println(" * filled: " + bag[0]);
                }

                result++;

            } else if (additionalRocks - bag[3] >= 0) {
                additionalRocks -= bag[3];
                if (isTest) {
                    System.out.println(" * filled: " + bag[0]);
                }

                result++;
            }
        }

        if (isTest) {
            System.out.println("------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
