// Question: https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        boolean isTest = false;
        int count = 0;
        int len = arr.length;
        int runningSum = 0;
        int sum = 0;

        for (int number: arr) {
            sum += number;
        }
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + "\nsum: " + sum);
        }

        // 1. No 3 partitions if sum is not divisible by 3.
        if (sum % 3 != 0) {
            return false;
        }

        /**
         2.  For sum to be split into 3 parts with equal sum,
             there must be at least 3 partitions, each with a sum of (sum / 3).
             (>= 3 because edge case: sum = 0, array is filled with 0s).
             Hence, traverse array from left to right and calculate running sum.
             If running sum == sum / 3, 1 valid partition, so reset running sum to 0
             to find next valid partition.
             If count >= 3, then there exists 3 valid partitions each with a sum of (sum / 3).
         */
        for (int i = 0; i < len; i++) {
            runningSum += arr[i];
            if (runningSum == sum / 3) {
                count++;
                runningSum = 0;
            }
        }

        return count >= 3;
    }
}