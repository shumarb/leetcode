// Question: https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/

class CountSubarraysWhereMaxElementsAppearsAtLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        boolean isTest = false;
        int countMaximum = 0;
        int left = 0;
        int maximum = 0;
        int n = nums.length;
        long result = 0;
        long totalElements = nums.length;

        for (int e: nums) {
            maximum = Math.max(e, maximum);
        }
        if (isTest) {
            System.out.println("k: " + k + "\nn: " + n + "\nmaximum: " + maximum + "\nnums: " + Arrays.toString(nums));
            System.out.println("-------------------------------------------------------------------------------------------");
        }

        for (int right = 0; right < n; right++) {
            if (nums[right] == maximum) {
                countMaximum++;
            }

            while (countMaximum >= k) {
                if (isTest) {
                    System.out.println(" * indices: [" + left + ", " + right + "] | total valid subarrays: " + (totalElements - right) + " | countMaximum: " + countMaximum + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
                }
                result += totalElements - right;
                if (nums[left++] == maximum) {
                    countMaximum--;
                }
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
