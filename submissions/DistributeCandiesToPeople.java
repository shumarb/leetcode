// Question: https://leetcode.com/problems/distribute-candies-to-people/description/

class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        boolean isTest = false;
        int i = 0;
        int k = 1;
        int n = num_people;
        int[] result = new int[n];

        while (candies > 0) {
            if (isTest) {
                System.out.println("i: " + i + " \n * before: " + Arrays.toString(result) + ", candies: " + candies);
            }

            // 1. Edge case: candies < k, so update current person with remaining candies.
            if (candies < k) {
                result[i] += candies;
                candies = 0;

                // 2. candies >= k, so increase current person's candies by k and decrement candies by k.
            } else {
                result[i] += k;
                candies -= k;
            }

            k++;
            i = (i + 1) % num_people;

            if (isTest) {
                System.out.println(" * after: " + Arrays.toString(result) + ", candies: " + candies);
                System.out.println("----------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("i: " + i + ", candies: " + candies);
            System.out.println("final result: " + Arrays.toString(result));
        }

        return result;
    }
}