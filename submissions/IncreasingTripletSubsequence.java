// Question: https://leetcode.com/problems/increasing-triplet-subsequence/description/

class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        // 1. Edge case: Less than 3 elements.
        if (nums.length < 3) {
            return false;
        }

        boolean isTest = false;
        long smallest = Long.MAX_VALUE;
        long secondSmallest = Long.MAX_VALUE;

        for (long e: nums) {
            if (e <= smallest) {
                smallest = e;
            } else if (e <= secondSmallest) {
                secondSmallest = e;
            } else {
                if (isTest) {
                    System.out.println(" * found: [" + smallest + ", " + secondSmallest + ", " + e + "]");
                }
                return true;
            }
        }

        return false;
    }
}