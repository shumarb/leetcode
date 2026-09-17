// Question: https://leetcode.com/problems/minimum-size-subarray-sum/description/

class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        boolean isTest = false;
        int left = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\ntarget: " + target);
            System.out.println("----------------------------------------------------------");
        }
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                int length = right - left + 1;
                result = Math.min(length, result);
                if (isTest) {
                    System.out.println(" * indices: [" + left + ", " + right + "] | sum: " + sum + " | length: " + length + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, left + length)));
                }

                sum -= nums[left++];
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------\nresult: " + result);
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
