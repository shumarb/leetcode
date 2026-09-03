// Question: https://leetcode.com/problems/longest-harmonious-subsequence/description/

class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        boolean isTest = false;
        int left = 0;
        int result = 0;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("------------------------------------------------------------");
        }
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }

            if (nums[right] - nums[left] == 1) {
                int length = right - left + 1;
                result = Math.max(length, result);

                if (isTest) {
                    System.out.println(" * indices: [" + left + ", " + right + "] | length: " + length + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
                }
            }
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
