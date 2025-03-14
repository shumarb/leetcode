// Question: https://leetcode.com/problems/maximum-ice-cream-bars/description/

class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        int maxIceCream = 0;
        boolean isTest = false;

        int maximumCost = costs[0];
        for (int cost: costs) {
            maximumCost = Math.max(maximumCost, cost);
        }

        int[] costFrequency = new int[maximumCost + 1];
        for (int cost: costs) {
            costFrequency[cost]++;
        }
        if (isTest) {
            System.out.println("coins: " + coins + "\ncosts: " + Arrays.toString(costs) + "\ncostFrequency: " + Arrays.toString(costFrequency));
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }

        for (int i = 1; i < costFrequency.length && coins > 0; i++) {
            while (costFrequency[i] > 0 && (coins - i) >= 0) {
                if (isTest) {
                    System.out.println("adding to cost: " + i);
                    System.out.println("before | coins: " + coins + ", maxIceCream: " + maxIceCream);
                }
                coins -= i;
                costFrequency[i]--;
                maxIceCream++;
                if (isTest) {
                    System.out.println("after | coins: " + coins + ", maxIceCream: " + maxIceCream);
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                }
            }
        }

        return maxIceCream;
    }
}