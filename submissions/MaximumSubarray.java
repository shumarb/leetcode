// Question: https://leetcode.com/problems/maximum-subarray/description/

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        boolean isTest = false;
        int bestLeft = 0;
        int bestRight = 0;
        int currentSubarraySum = nums[0];
        int left = 0;
        int result = nums[0];

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\n----------------------------------------------------");
            System.out.println(" * indices: [" + bestLeft + ", " + bestRight + "] | maximum subarray sum: " + result);
        }
        for (int right = 1; right < nums.length; right++) {
            int incoming = nums[right];

            // 1. If adding incoming current window [left, right - 1] generates greater current subarray sum, expand window and add it to the sum; else set window's left as right.
            if (incoming + currentSubarraySum > incoming) {
                currentSubarraySum += incoming;

            } else {
                currentSubarraySum = incoming;
                left = right;
            }

            if (currentSubarraySum > result) {
                bestLeft = left;
                bestRight = right;
                result = currentSubarraySum;
                if (isTest) {
                    System.out.println(" * indices: [" + bestLeft + ", " + bestRight + "] | maximum subarray sum: " + result);
                }
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
