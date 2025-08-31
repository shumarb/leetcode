// Question: https://leetcode.com/problems/distribute-candies-to-people/description/

class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int candy = 1;
        int i = 0;

        /**
         1.  While there are sufficient amount of candy,
             give it to i-th person and update i and remaining candies.
         */
        while (candies >= candy) {
            result[i % num_people] += candy;
            candies -= candy;
            candy++;
            i++;
        }

        // 2. Edge case: If candies > 0, give it all i-th person.
        if (candies > 0) {
            result[i % num_people] += candies;
        }

        return result;
    }
}