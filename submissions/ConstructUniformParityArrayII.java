// Question: https://leetcode.com/problems/construct-uniform-parity-array-ii/description/

class ConstructUniformParityArrayII {
    public boolean uniformArray(int[] nums1) {
        boolean isTest = false;
        int countOdd = 0;
        int minimumOdd = Integer.MAX_VALUE;

        for (int e: nums1) {
            if (e % 2 == 1) {
                countOdd++;
                minimumOdd = Math.min(e, minimumOdd);
            }
        }
        if (isTest) {
            System.out.println("nums1: " + Arrays.toString(nums1) + "\ncountOdd: " + countOdd + "\nminimumOdd: " + minimumOdd);
        }

        // 1. All elements have same parity.
        if (countOdd == nums1.length || minimumOdd == Integer.MAX_VALUE) {
            return true;
        }

        // 2. For every integer, determine if a positive integer smaller than itself can be formed (even - odd = odd). If not, impossible to form uniform parity array.
        for (int e: nums1) {
            if (e % 2 == 0 && e < minimumOdd) {
                return false;
            }
        }

        return true;
    }
}
