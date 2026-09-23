// Question: https://leetcode.com/problems/split-array-with-minimum-difference/description/

class SplitArrayWithMinimumDifference {
    public long splitArray(int[] nums) {
        int n = nums.length;
        boolean[] isDecreasing = new boolean[n];
        boolean[] isIncreasing = new boolean[n];
        boolean isTest = false;
        long leftSum = 0;
        long result = Long.MAX_VALUE;
        long rightSum = 0;

        for (int e: nums) {
            rightSum += e;
        }
        isIncreasing[0] = isDecreasing[n - 1] = true;
        for (int i = 1; i < n; i++) {
            if (isIncreasing[i - 1] && nums[i] > nums[i - 1]) {
                isIncreasing[i] = true;

            } else {
                break;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (isDecreasing[i + 1] && nums[i] > nums[i + 1]) {
                isDecreasing[i] = true;

            } else {
                break;
            }
        }
        if (isTest) {
            System.out.print("nums:   " + Arrays.toString(nums) + "\nisIncreasing: " + Arrays.toString(isIncreasing) + "\nisDecreasing: " + Arrays.toString(isDecreasing) + "\n----------------------------------------------");
        }

        for (int i = 0; i < n - 1; i++) {
            int element = nums[i];
            leftSum += element;
            rightSum -= element;

            if (isTest) {
                System.out.println("\n* [0, " + i + "] | leftSum: " + leftSum + " | [" + (i + 1) + ", " + (n - 1) + "] | rightSum: " + rightSum);
            }
            if (isIncreasing[i] && isDecreasing[i + 1]) {
                long absoluteDifference = Math.abs(leftSum - rightSum);
                if (isTest) {
                    System.out.println("** valid | absoluteDifference: " + absoluteDifference);
                }

                result = Math.min(absoluteDifference, result);
            }
        }
        if (isTest) {
            System.out.print("----------------------------------------------\nresult: " + result);
        }

        return result == Long.MAX_VALUE ? -1 : result;
    }
}
