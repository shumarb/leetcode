// Question: https://leetcode.com/problems/find-greatest-common-divisor-of-array/description/

class FindGreatestCommonDivisorOfArray {
    public int findGCD(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int number: nums) {
            largest = Math.max(number, largest);
            smallest = Math.min(number, smallest);
        }

        /**
         1.  Find greatest common denominator
             of largest and smallets using Euclidean's algorithm.
         */
        return findGCD(smallest, largest);
    }

    private int findGCD(int smallest, int largest) {
        return (largest == 0) ? smallest : findGCD(largest, smallest % largest);
    }
}