// Question: https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/description/

class MinimumCostOfBuyingCandiesWithDiscount {
    public int minimumCost(int[] cost) {
        boolean isTest = false;
        int count = 0;
        int result = 0;

        sort(cost);

        for (int i = cost.length - 1; i >= 0; i--) {
            // 1. Among 3 consecutive values, count the last 2 to get the first one for free.
            if (++count == 3) {
                count = 0;
            } else {
                result += cost[i];
            }
        }
        if (isTest) {
            System.out.println("sorted cost: " + Arrays.toString(cost) + "\nresult: " + result);
        }

        return result;
    }

    private void sort(int[] cost) {
        int[] count = new int[101];
        int j = 0;

        for (int e: cost) {
            count[e]++;
        }

        for (int i = 1; i < count.length; i++) {
            while (count[i]-- > 0) {
                cost[j++] = i;
            }
        }
    }
}
