// Question: https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/description/

class MinimumCostOfBuyingCandiesWithDiscount {
    public int minimumCost(int[] cost) {
        int minimumCost = 0;

        // 1. Edge case: There are up to 2 candies, so buy it all.
        if (cost.length <= 2) {
            for (int price: cost) {
                minimumCost += price;
            }
            return minimumCost;
        }

        boolean isTest = false;

        Arrays.sort(cost);
        if (isTest) {
            System.out.println("sorted cost: " + Arrays.toString(cost));
            System.out.println("-------------------------------------------------------------------------------------");
        }

        int i = 0;
        for (i = cost.length - 1; i >= 2; i -= 3) {
            if (isTest) {
                System.out.println(" * indices: " + i + ", " + (i - 1) + ", " + (i - 2));
                System.out.println(" * elements: " + cost[i] + ", " + cost[i - 1] + ", " + cost[i - 2]);
            }

            if (cost[i - 2] <= cost[i - 1]) {
                if (isTest) {
                    System.out.println(" * adding to minimumCost:");
                    System.out.println(" ** indices: " + (i - 1) + ", " + i);
                    System.out.println(" ** elements: " + cost[i - 1] + ", " + cost[i]);
                }
                minimumCost += (cost[i] + cost[i - 1]);
                if (isTest) {
                    System.out.println(" *** so far, minimumCost: " + minimumCost);
                }
            }

            if (isTest) {
                System.out.println("-------------------------------------------------------------------------------------");
            }
        }

        while (i >= 0) {
            minimumCost += cost[i--];
        }

        if (isTest) {
            System.out.println("i: " + i);
            System.out.println("minimum cost: " + minimumCost);
        }

        return minimumCost;
    }
}