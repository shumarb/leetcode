// Question: https://leetcode.com/problems/find-the-largest-almost-missing-integer/description/

class FindTheLargestAlmostMissingInteger {
    public int largestInteger(int[] nums, int k) {
        boolean isTest = false;
        int[] count;
        int largest = 0;
        int result = -1;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];

        for (int i = 0; i <= nums.length - k; i++) {
            boolean[] isChecked = new boolean[largest + 1];
            int[] subarray = Arrays.copyOfRange(nums, i, i + k);

            for (int e: subarray) {
                if (isChecked[e]) {
                    continue;
                }

                count[e]++;
                isChecked[e] = true;
            }
            if (isTest) {
                System.out.println(" * indices: [" + i + ", " + (i + k - 1) + "] | subarray: " + Arrays.toString(subarray) + " | count: " + Arrays.toString(count));
            }
        }

        for (int i = largest; i >= 0; i--) {
            if (count[i] == 1) {
                result = i;
                break;
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------\ncount: " + Arrays.toString(count) + "\nresult: " + result);
        }

        return result;
    }
}
