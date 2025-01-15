// Question: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/

class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public int maximumCount(int[] nums) {
        int countPositive = 0;
        int countNegative = 0;
        for (int x: nums) {
            if (x < 0) {
                countNegative++;
            }
            if (x > 0) {
                countPositive++;
            }
        }
        return Math.max(countPositive, countNegative);
    }
}


/**
 * Solution done using binary search of last negative index and first positive index
 * with runtime of O(log N) time,
 * but performance after submission shows solution runs in 1ms, beating 20.51%
 *
 *
 * class Solution {
 *     private boolean t = false;
 *
 *     public int maximumCount(int[] nums) {
 *         int firstP = getFirstP(nums);
 *         int lastN = getLastN(nums);
 *         int countP = countPositive(nums, firstP);
 *         int countN = countNegative(nums, lastN);
 *         return Math.max(countP, countN);
 *     }
 *
 *     private int countNegative(int[] nums, int n) {
 *         if (n == -1) {
 *             return 0;
 *         }
 *         int count = 0;
 *         for (int i = 0; i < n; i++) {
 *             count++;
 *         }
 *
 *         count += 1; // increase by 1 due to 0-based counting if counting from start of array
 *         if (t) {
 *             System.out.println("count negative: " + count);
 *         }
 *         return count;
 *     }
 *
 *     private int countPositive(int[] nums, int p) {
 *         if (p == -1) {
 *             return 0;
 *         }
 *         int count = 0;
 *         for (int i = p; i < nums.length; i++) {
 *             count++;
 *         }
 *
 *         if (t) {
 *             System.out.println("count positive: " + count);
 *         }
 *         return count;
 *     }
 *
 *     private int getLastN(int[] nums) {
 *         int low = 0;
 *         int high = nums.length - 1;
 *         int index = -1;
 *
 *         while (low <= high) {
 *             int mid = low + (high - low) / 2;
 *             if (nums[mid] >= 0) {
 *                 high = mid - 1;
 *             } else {
 *                 index = mid;
 *                 low = mid + 1;
 *             }
 *         }
 *
 *         if (t) {
 *             System.out.println("negative | index: " + index);
 *         }
 *         return index;
 *     }
 *
 *     private int getFirstP(int[] nums) {
 *         int index = -1;
 *         int low = 0;
 *         int high = nums.length - 1;
 *
 *         while (low <= high) {
 *             int mid = low + (high - low) / 2;
 *             if (nums[mid] <= 0) {
 *                 low = mid + 1;
 *             } else {
 *                 index = mid;
 *                 high = mid - 1;
 *             }
 *         }
 *
 *         if (t) {
 *             System.out.println("positive | index: " + index);
 *         }
 *         return index;
 *     }
 * }
 */