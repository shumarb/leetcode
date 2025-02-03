// Question: https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/

class DifferenceBetweenElementSumAndDigitSumOfAnArray {
    public int differenceOfSum(int[] nums) {
        int dSum = 0;
        int eSum = 0;
        boolean t = false;
        for (int x: nums) {
            eSum += x;
            if (x > 9) {
                dSum += getDigitSum(x);
            } else {
                dSum += x;
            }
        }
        if (t) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("digit sum: " + dSum + " | element sum: " + eSum);
        }

        return Math.abs(dSum - eSum);
    }

    private int getDigitSum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += (x % 10);
            x /= 10;
        }
        return sum;
    }
}