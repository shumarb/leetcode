// Question: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        boolean isTest = false;
        int high = 0;
        int leastWeightCapacity = 0;
        int low = Integer.MIN_VALUE;

        for (int weight: weights) {
            high += weight;
            low = Math.max(low, weight);
        }
        if (isTest) {
            System.out.println("low: " + low + ", high: " + high);
            System.out.println("-----------------------------------------------");
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isTest) {
                System.out.println("low: " + low + ", mid: " + mid + ", high: " + high);
            }
            if (isValid(weights, days, mid)) {
                leastWeightCapacity = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if (isTest) {
                System.out.println(" * leastWeightCapacity: " + leastWeightCapacity);
                System.out.println("-----------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final leastWeightCapacity: " + leastWeightCapacity);
        }

        return leastWeightCapacity;
    }

    private boolean isValid(int[] weights, int dayLimit, int weightLimit) {
        int totalDays = 0;
        int totalWeight = 0;

        for (int weight: weights) {
            if (totalWeight + weight > weightLimit) {
                totalDays++;
                totalWeight = weight;
            } else {
                totalWeight += weight;
            }
        }
        if (totalWeight > 0) {
            totalDays++;
        }

        return totalDays <= dayLimit;
    }
}