// Question: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/

class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public int maximumCount(int[] nums) {
        boolean isTest = false;

        int lastNegativeIndex = findLastNegativeIndex(nums);
        int firstPositiveIndex = findFirstPositiveIndex(nums);
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("last negative index: " + lastNegativeIndex);
            System.out.println("first positive index: " + firstPositiveIndex);
        }

        // 1. Array comprises on non-positive values.
        if (lastNegativeIndex == -1 && firstPositiveIndex != -1) {
            return nums.length - firstPositiveIndex;

            // 2. Array comprises of non-negative values.
        } else if (firstPositiveIndex == -1 && lastNegativeIndex != -1) {
            return lastNegativeIndex + 1;

            // 3. Array comprises of zeroes.
        } else if (lastNegativeIndex == -1 && firstPositiveIndex == -1) {
            return 0;

        } else {
            /**
             4.  Array comprises of positive and negative values, and may contain zeroes,
             hence determine the number of negative elements (lastNegativeIndex + 1)
             and the number of positive elements (nums.length - firstPostiveIndex),
             and return the maximum out of those 2 values.
             */
            return Math.max(lastNegativeIndex + 1, nums.length - firstPositiveIndex);
        }
    }

    private int findFirstPositiveIndex(int[] nums) {
        // [-4, -3, -1, 0, 1, 3, 5, 7]
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= 0) {
                low = mid + 1;
            } else {
                index = mid;
                high = mid - 1;
            }
        }

        return index;
    }

    private int findLastNegativeIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= 0) {
                high = mid - 1;
            } else {
                index = mid;
                low = mid + 1;
            }
        }

        return index;
    }
}