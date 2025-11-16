// Question: https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/description/

class AdjacentIncreasingSubarraysDetectionOne {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        boolean isTest = false;

        for (int i = 0; i <= nums.size() - 2 * k; i++) {
            int[] l1 = new int[k];
            int[] l2 = new int[k];
            int a = 0;
            int b = 0;

            for (int j = i; j < (i + k); j++) {
                l1[a++] = nums.get(j);
            }
            for (int c = i + k; c < (i + 2 * k); c++) {
                l2[b++] = nums.get(c);
            }
            if (isTest) {
                System.out.println("--------------------------------\nl1: " + Arrays.toString(l1) + "\nl2: " + Arrays.toString(l2));
            }

            if (isValid(l1) && isValid(l2)) {
                return true;
            }
        }

        return false;
    }

    private boolean isValid(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }

        return true;
    }
}