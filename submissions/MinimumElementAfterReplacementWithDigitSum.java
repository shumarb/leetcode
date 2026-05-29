// Question: https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/description/

class MinimumElementAfterReplacementWithDigitSum {
    public int minElement(int[] nums) {
        int result = Integer.MAX_VALUE;

        for (int e: nums) {
            int digitSum = 0;
            while (e > 0) {
                digitSum += e % 10;
                e /= 10;
            }
            result = Math.min(digitSum, result);
        }

        return result;
    }
}
