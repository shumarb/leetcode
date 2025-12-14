// Question: https://leetcode.com/problems/count-subarrays-with-majority-element-i/description/

class CountSubarraysWithMajorityElementOne {
    public int countMajoritySubarrays(int[] nums, int target) {
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == target) {
                    count++;
                }
                int len = j - i + 1;
                if (2 * count > len) {
                    if (isTest) {
                        System.out.println(" * valid subarray: [" + i + ", " + j + "] -> " + Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)));
                    }
                    result++;
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------\nresult: " + result);
        }

        return result;
    }
}