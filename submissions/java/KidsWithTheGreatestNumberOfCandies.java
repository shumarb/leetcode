// Question: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/

class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maximumCandy = candies[0];
        boolean isTest = false;

        for (int candy: candies) {
            maximumCandy = Math.max(candy, maximumCandy);
        }
        if (isTest) {
            System.out.println("candies: " + Arrays.toString(candies) + "\nextraCandies: " + extraCandies + ", maximum candy: " + maximumCandy);
        }

        for (int i = 0; i < candies.length; i++) {
            if ((candies[i] + extraCandies) >= maximumCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}