// Question: https://leetcode.com/problems/water-bottles/description/

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        boolean isTest = false;
        int total = numBottles;

        while (numBottles >= numExchange) {
            if (isTest) {
                System.out.println("before: numBottles: " + numBottles + ", total: " + total);
            }

            int newBottles = (numBottles / numExchange);
            total += newBottles;
            numBottles = newBottles + (numBottles % numExchange);

            if (isTest) {
                System.out.println(" * newBottles: " + newBottles + "\nafter: numBottles: " + numBottles + ", total: " + total);
                System.out.println("---------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("total: " + total + ", numBottles: " + numBottles);
        }

        return total;
    }
}