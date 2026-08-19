// Question: https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/description/

class MaximumDistanceBetweenAPairOfValues {
    public int maxDistance(int[] nums1, int[] nums2) {
        boolean isTest = false;
        int result = 0;

        if (isTest) {
            System.out.println("nums1: " + Arrays.toString(nums1) + "\nnums2: " + Arrays.toString(nums2));
            System.out.println("--------------------------------------------");
        }
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            int j = getIndex(key, i, nums2.length - 1, nums2);

            if (isTest) {
                System.out.println(" * i: " + i + " | key: " + key + " | j in nums2: " + j);
            }
            if (j > -1) {
                result = Math.max(result, j - i);
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private int getIndex(int key, int left, int right, int[] arr) {
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = arr[mid];

            // 1. Find right-most value >= key.
            //    Current value and its index meets requirement,
            //    there may be a value in range [mid + 1, right] that's >= key.
            if (key <= value) {
                result = mid;
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
