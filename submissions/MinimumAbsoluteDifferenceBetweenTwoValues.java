// Question: https://leetcode.com/problems/minimum-absolute-difference-between-two-values/description/

class MinimumAbsoluteDifferenceBetweenTwoValues {
    public int minAbsoluteDifference(int[] nums) {
        boolean isTest = false;
        int last1Index = -1;
        int last2Index = -1;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                last1Index = i;
                if (last2Index != -1) {
                    if (isTest) {
                        System.out.println(" * valid: (" + last1Index + ", " + last2Index + ")");
                    }
                    result = Math.min(Math.abs(last1Index - last2Index), result);
                }
            }

            if (nums[i] == 2) {
                last2Index = i;
                if (last1Index != -1) {
                    if (isTest) {
                        System.out.println(" * valid: (" + last1Index + ", " + last2Index + ")");
                    }
                    result = Math.min(Math.abs(last1Index - last2Index), result);
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
