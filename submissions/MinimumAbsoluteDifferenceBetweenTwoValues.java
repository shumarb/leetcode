// Question: https://leetcode.com/problems/minimum-absolute-difference-between-two-values/description/

class MinimumAbsoluteDifferenceBetweenTwoValues {
    public int minAbsoluteDifference(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == 1 && nums[j] == 2) {
                    if (isTest) {
                        System.out.println("(i: " + i + ", j: " + j + ")");
                    }
                    result = Math.min(Math.abs(i - j), result);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (nums[i] == 1 && nums[j] == 2) {
                    if (isTest) {
                        System.out.println("(i: " + i + ", j: " + j + ")");
                    }
                    result = Math.min(Math.abs(i - j), result);
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
