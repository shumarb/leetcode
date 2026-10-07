// Question: https://leetcode.com/problems/third-maximum-number/

class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        boolean isTest = false;
        long maximum = Long.MIN_VALUE;
        long secondMaximum = Long.MIN_VALUE;
        long thirdMaximum = Long.MIN_VALUE;

        for (int e: nums) {
            if (e > maximum) {
                thirdMaximum = secondMaximum;
                secondMaximum = maximum;
                maximum = e;

            } else if (maximum > e && e > secondMaximum) {
                thirdMaximum = secondMaximum;
                secondMaximum = e;

            } else if (secondMaximum > e && e > thirdMaximum) {
                thirdMaximum = e;
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nmaximum: " + maximum + "\nsecondMaximum: " + secondMaximum + "\nthirdMaximum: " + thirdMaximum);
        }

        return thirdMaximum == Long.MIN_VALUE ? (int) maximum : (int) thirdMaximum;
    }
}
