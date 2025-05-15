// Question: https://leetcode.com/problems/count-partitions-with-even-sum-difference/description/

class CountPartitionsWithEvenSumDifference {
    public int countPartitions(int[] nums) {
        boolean isTest = false;
        int countPartitions = 0;
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];

        prefix[0] = nums[0];
        suffix[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }
        if (isTest) {
            System.out.println("nums:     " + Arrays.toString(nums));
            System.out.println("prefix:   " + Arrays.toString(prefix));
            System.out.println("suffix:   " + Arrays.toString(suffix));
            System.out.println("----------------------------------------------------------------------");
        }

        for (int i = 0; i < len - 1; i++) {
            if ((prefix[i] - suffix[i + 1]) % 2 == 0) {
                countPartitions++;
            }
        }
        if (isTest) {
            System.out.println("countPartitions: " + countPartitions);
        }

        return countPartitions;
    }
}