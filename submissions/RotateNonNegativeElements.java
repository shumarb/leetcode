// Question: https://leetcode.com/problems/rotate-non-negative-elements/description/

class RotateNonNegativeElements {
    public int[] rotateElements(int[] nums, int k) {
        boolean isTest = false;
        int index = 0;
        int n = nums.length;
        int total = 0;
        int[] nonNegatives = new int[n];

        for (int e: nums) {
            if (e >= 0) {
                nonNegatives[total++] = e;
            }
        }

        // 1. No non-negative numbers, so no rotation of elements.
        if (total == 0) {
            return nums;
        }

        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums) + "\ntotal non negatives: " + total + "\nbefore rotation, nonNegatives: " + Arrays.toString(Arrays.copyOfRange(nonNegatives, 0, total)));
        }
        k %= total;
        rotate(nonNegatives, 0, k - 1);
        rotate(nonNegatives, k, total - 1);
        rotate(nonNegatives, 0, total - 1);

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                nums[i] = nonNegatives[index++];
            }
        }
        if (isTest) {
            System.out.println("after rotation, nonNegatives:  " + Arrays.toString(Arrays.copyOfRange(nonNegatives, 0, index)) + "\nnums: " + Arrays.toString(nums));
        }

        return nums;
    }

    private void rotate(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}
