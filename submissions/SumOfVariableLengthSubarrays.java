// Question: https://leetcode.com/problems/sum-of-variable-length-subarrays/description/

class SumOfVariableLengthSubarrays {
    public int subarraySum(int[] nums) {
        boolean isTest = false;
        int subarraySum = 0;

        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            int[] subarray = Arrays.copyOfRange(nums, start, i + 1);

            for (int number: subarray) {
                subarraySum += number;
            }
            if (isTest) {
                System.out.println(" * i: " + i + " -> subarray: " + Arrays.toString(subarray));
                System.out.println("----------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("subarraySum: " + subarraySum);
        }

        return subarraySum;
    }
}