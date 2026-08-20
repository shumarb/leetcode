// Question: https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/description/

class CountTheNumberOfIncremovableSubarraysI {
    public int incremovableSubarrayCount(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            boolean[] isIndexExcluded = new boolean[n];

            for (int j = i; j < n; j++) {
                isIndexExcluded[j] = true;
                if (isTest) {
                    System.out.print(" * indices to exclude: " + Arrays.toString(isIndexExcluded));
                }

                int[] values = new int[n];
                int index = 0;

                for (int k = 0; k < n; k++) {
                    if (isIndexExcluded[k]) {
                        continue;
                    }
                    values[index++] = nums[k];
                }
                if (isTest) {
                    System.out.println(" | values: " + Arrays.toString(values));
                }

                boolean isIncreasing = true;
                for (int k = 1; k < index; k++) {
                    if (values[k] <= values[k - 1]) {
                        isIncreasing = false;
                        break;
                    }
                }
                if (isIncreasing) {
                    result++;
                }
            }
        }

        return result;
    }
}
