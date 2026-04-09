// Question: https://leetcode.com/problems/minimum-absolute-difference-between-two-values/description/

class MinimumAbsoluteDifferenceBetweenTwoValues {
    public int minAbsoluteDifference(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int first = nums[i];
            for (int j = i + 1; j < n; j++) {
                int second = nums[j];
                if ((first == 1 && second == 2) || (first == 2 && second == 1)) {
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
