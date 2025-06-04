// Question: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/

class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public int maximumCount(int[] nums) {
        boolean isTest = false;

        int countNegatives = countNegatives(nums);
        int countPositives = countPositives(nums);
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("number of negatives: " + countNegatives);
            System.out.println("number of positives: " + countPositives);
        }

        return Math.max(countPositives, countNegatives);
    }

    private int countPositives(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int count = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= 0) {
                low = mid + 1;
            } else {
                count = nums.length - mid;
                high = mid - 1;
            }
        }

        return count;
    }

    private int countNegatives(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int count = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= 0) {
                high = mid - 1;
            } else {
                count = mid + 1;
                low = mid + 1;
            }
        }

        return count;
    }
}