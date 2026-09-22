// Question: https://leetcode.com/problems/number-of-ways-to-split-array/description/

class NumberOfWaysToSplitArray {
    public int waysToSplitArray(int[] nums) {
        boolean isTest = false;
        int result = 0;
        long leftSum = 0;
        long rightSum = 0;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\n------------------------------------");
        }
        for (int e: nums) {
            rightSum += e;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            leftSum += current;
            rightSum -= current;
            if (isTest) {
                System.out.print("i: " + i + "\n * leftSum: " + leftSum + "\n * rightSum: " + rightSum);
            }

            if (leftSum >= rightSum) {
                result++;
                if (isTest) {
                    System.out.println("\n ** split\n");
                }

            } else {
                if (isTest) {
                    System.out.println("\n");
                }
            }
        }
        if (isTest) {
            System.out.print("------------------------------------\nresult: " + result);
        }

        return result;
    }
}
