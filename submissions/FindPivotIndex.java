// Question: https://leetcode.com/problems/find-pivot-index/description/

class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        boolean isTest = false;
        int leftSum = 0;
        int rightSum = 0;

        for (int e: nums) {
            rightSum += e;
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            rightSum -= current;
            if (isTest) {
                System.out.println(" * i: " + i + " | leftSum: " + leftSum + ", rightSum: " + rightSum);
            }
            if (leftSum == rightSum) {
                return i;
            }

            leftSum += current;
        }

        return -1;
    }
}
