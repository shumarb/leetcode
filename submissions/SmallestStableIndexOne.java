// Question: https://leetcode.com/problems/smallest-stable-index-i/description/

class SmallestStableIndexOne class Solution {
    public int firstStableIndex(int[] nums, int k) {
        boolean isTest = false;
        int maximum = nums[0];
        int n = nums.length;
        int[] suffix = new int[n];

        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], nums[i]);
        }
        if (isTest) {
            System.out.println("nums:   " + Arrays.toString(nums));
            System.out.println("suffix: " + Arrays.toString(suffix));
            System.out.println("----------------------------------");
        }

        for (int i = 0; i < n; i++) {
            maximum = Math.max(maximum, nums[i]);
            int minimum = suffix[i];
            int instability = maximum - minimum;
            if (isTest) {
                System.out.println("i: " + i + " | [" + maximum + ", " + minimum + "] | instability: " + instability);
            }

            if (instability <= k) {
                if (isTest) {
                    System.out.println(" * result: " + i);
                }
                return i;
            }
        }

        return -1;
    }
}
