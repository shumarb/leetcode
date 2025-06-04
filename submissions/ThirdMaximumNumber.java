// Question: https://leetcode.com/problems/third-maximum-number/

class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        boolean isTest = false;

        for (int number: nums) {
            /**
             1.  Ensures only top three distinct elements are processed
             if nums has >= 3 distinct elements
             */
            if (firstMax == number || secondMax == number || thirdMax == number) {
                continue;
            } else {
                if (number > firstMax) {
                    thirdMax = secondMax;
                    secondMax = firstMax;
                    firstMax = number;
                } else if (number > secondMax) {
                    thirdMax = secondMax;
                    secondMax =  number;
                } else if (number > thirdMax) {
                    thirdMax = number;
                }
            }

            if (isTest) {
                System.out.println("firstMax so far: " + firstMax);
                System.out.println("secondMax so far: " + secondMax);
                System.out.println("thirdMax so far: " + thirdMax);
            }
        }

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("firstMax: " + firstMax);
            System.out.println("secondMax: " + secondMax);
            System.out.println("thirdMax: " + thirdMax);
        }

        return (thirdMax == Long.MIN_VALUE) ? (int) firstMax : (int) thirdMax;
    }
}