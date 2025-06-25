// Question: https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/description/

class MaximumNumberOfOperationsWithTheSameScoreOne {
    public int maxOperations(int[] nums) {
        boolean isTest = false;
        int countOperations = 1;
        int i = 2;
        int score = nums[0] + nums[1];

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("-----------------------------------------------");
            System.out.println("indices: 0, 1" + " | elements: " + nums[0] + ", " + nums[1]);
            System.out.println("score: " + score + " | sum: " + (nums[0] + nums[1]));
        }

        while (i + 1 < nums.length && nums[i] + nums[i + 1] == score) {
            if (isTest) {
                System.out.println("-----------------------------------------------");
                System.out.println("indices: " + i + ", " + (i + 1) + " | elements: " + nums[i] + ", " + nums[i + 1]);
                System.out.println("score: " + score + " | sum: " + (nums[i] + nums[i + 1]));
            }
            countOperations++;
            i += 2;
        }

        return countOperations;
    }
}