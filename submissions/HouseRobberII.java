// Question: https://leetcode.com/problems/house-robber-ii/description/

class HouseRobberII {
    private boolean isTest;

    public int rob(int[] nums) {
        isTest = false;
        int n = nums.length;
        int robFirstToSecondLast;
        int robSecondToLast;

        if (n == 1) {
            return nums[0];

        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
        }

        robFirstToSecondLast = getTotal(nums.clone(), 0, nums.length - 2);
        robSecondToLast = getTotal(nums.clone(), 1, nums.length - 1);

        return Math.max(robFirstToSecondLast, robSecondToLast);
    }

    private int getTotal(int[] nums, int start, int end) {
        for (int i = end - 1; i >= 0; i--) {
            int totalIfAvoidCurrent = nums[i + 1];
            int totalIfRobCurrent = nums[i] + ((i + 2 <= end) ? nums[i + 2] : 0);
            nums[i] = Math.max(totalIfAvoidCurrent, totalIfRobCurrent);
        }
        if (isTest) {
            System.out.println(" * index: [" + start + ", " + end + "] | subarray dp: " + Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));
        }

        return Math.max(nums[start], nums[start + 1]);
    }
}
