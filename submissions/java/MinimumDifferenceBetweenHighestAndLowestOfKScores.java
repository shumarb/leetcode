// Question: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/

class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        /**
         1.  Edge case: Array contains 1 element,
             hence minimum difference is 0 because no other elements to compare.
         */
        if (nums.length == 1) {
            return 0;
        }

        boolean isTest = false;
        Arrays.sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\nk: " + k);
            System.out.println("-------------------------------------------------------------------------------");
        }

        /**
         2.  Window size comprises of the entire array,
             hence return difference between its maximum and minimum element.
         */
        if (k == nums.length) {
            return nums[nums.length - 1] - nums[0];
        }

        int minimumDifference = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int largestInCurrentWindow = nums[i + k - 1];
            int smallestInCurrentWindow = nums[i];
            int currentDifference = largestInCurrentWindow - smallestInCurrentWindow;
            if (isTest) {
                System.out.println(" * indices: " + i + ", " + (i + k - 1));
                System.out.println(" * elements: " + smallestInCurrentWindow + ", " + largestInCurrentWindow);
                System.out.println(" * current difference: " + currentDifference + ", minimum difference: " + minimumDifference);
            }
            minimumDifference = Math.min(minimumDifference, currentDifference);
            if (isTest) {
                System.out.println(" ** after comparison, minimum difference: " + minimumDifference);
                System.out.println("-------------------------------------------------------------------------------");
            }
        }

        return minimumDifference;
    }
}