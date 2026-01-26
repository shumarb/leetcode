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
        int minimumDifference = Integer.MAX_VALUE;
        int n = nums.length;

        Arrays.sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\nk: " + k);
            System.out.println("-------------------------------------------------------------------------------");
        }

        /**
         2.  Window size comprises of the entire array,
             hence return difference between its maximum and minimum element.
         */
        if (k == n) {
            return nums[n - 1] - nums[0];
        }

        for (int i = 0; i <= n - k; i++) {
            int largestInWindow = nums[i + k - 1];
            int smallestInWindow = nums[i];
            int currentDifference = largestInWindow - smallestInWindow;
            if (isTest) {
                System.out.println(" * indices: " + i + ", " + (i + k - 1));
                System.out.println(" * elements: " + smallestInWindow + ", " + largestInWindow);
                System.out.println(" * current difference: " + currentDifference + ", minimum difference: " + minimumDifference);
            }
            minimumDifference = Math.min(currentDifference, minimumDifference);
            if (isTest) {
                System.out.println(" ** after comparison, minimum difference: " + minimumDifference);
                System.out.println("-------------------------------------------------------------------------------");
            }
        }

        return minimumDifference;
    }
}