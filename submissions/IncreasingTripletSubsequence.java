// Question: https://leetcode.com/problems/increasing-triplet-subsequence/description/

class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
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