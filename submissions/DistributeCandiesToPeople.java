// Question: https://leetcode.com/problems/distribute-candies-to-people/description/

class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        boolean isTest = false;
        int[] result = new int[num_people];

        for (int give = 1, i = 0; candies > 0; give++, i++) {
            if (i >= num_people) {
                i = 0;
            }
            if (isTest) {
                System.out.println("i: " + i + "\nbefore: " + Arrays.toString(result) + ", candies: " + candies);
            }

            result[i] += Math.min(give, candies);
            candies -= give;

            if (isTest) {
                System.out.println("after: " + Arrays.toString(result) + ", candies: " + candies);
                System.out.println("------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final result: " + Arrays.toString(result) + ", candies: " + candies);
            System.out.println("------------------------------------------");
        }

        return result;
    }
}