// Question: https://leetcode.com/problems/count-partitions-with-even-sum-difference/description/

class CountPartitionsWithEvenSumDifference {
    public int countPartitions(int[] nums) {
        boolean isTest = false;
        int countPartitions = 0;
        int leftSum = 0;
        int len = nums.length;
        int total = 0;

        for (int number: nums) {
            total += number;
        }

        /**
         1.  Traverse from start to penultimate element
             to ensure there are 2 partitions checked:
             [0, i] & and [i + 1...n - 1].
         */
        for (int i = 0; i < len - 1; i++) {
            leftSum += nums[i];
            if ((leftSum - (total - leftSum)) % 2 == 0) {
                countPartitions++;
            }
            if (isTest) {
                System.out.println("i: " + i + "\n * leftSum: " + leftSum + " | rightSum: " + (total - leftSum));
                System.out.println(" * difference: " + (leftSum - (total - leftSum)) + "\n * countPartitions: " + countPartitions);
                System.out.println("--------------------------------------------------------------------------------------");
            }
        }

        return countPartitions;
    }
}