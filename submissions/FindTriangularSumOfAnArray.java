// Question: https://leetcode.com/problems/find-triangular-sum-of-an-array/description/

class FindTriangularSumOfAnArray {
    public int triangularSum(int[] nums) {
        boolean isTest = false;

        while (nums.length > 1) {
            if (isTest) {
                System.out.println("before, nums: " + Arrays.toString(nums));
            }

            int[] updated = new int[nums.length - 1];
            int j = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                updated[j++] = (nums[i] + nums[i + 1]) % 10;
            }

            nums = updated;
            if (isTest) {
                System.out.println("after, nums: " + Arrays.toString(nums));
                System.out.println("--------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final nums: " + Arrays.toString(nums));
        }

        return nums[0];
    }
}