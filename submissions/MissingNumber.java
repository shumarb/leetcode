// Question: https://leetcode.com/problems/missing-number/description/

class MissingNumber {
    public int missingNumber(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int nSum = (n * (n + 1)) / 2;
        int sum = 0;

        for (int e: nums) {
            sum += e;
        }
        if (isTest) {
            System.out.println("nSum: " + nSum + "\nsum: " + sum + "\nmissing number: " + (nSum - sum));
        }

        return nSum - sum;
    }
}
