// Question: https://leetcode.com/problems/find-the-largest-almost-missing-integer/description/

class FindTheLargestAlmostMissingInteger {
    public int largestInteger(int[] nums, int k) {
        boolean isTest = false;
        int largest = nums[0];
        int len = nums.length;
        int[] frequency;
        int[] window = new int[k];

        for (int number: nums) {
            largest = Math.max(largest, number);
        }
        frequency = new int[largest + 1];

        for (int i = 0; i <= len - k; i++) {
            int j = i;
            for (int a = 0; a < k; a++) {
                window[a] = nums[j++];
            }
            if (isTest) {
                System.out.println("window: " + Arrays.toString(window));
            }
            update(window, frequency);
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------");
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums) + "\nfrequency: " + Arrays.toString(frequency));
        }
        for (int i = frequency.length - 1; i >= 0; i--) {
            if (frequency[i] == 1) {
                return i;
            }
        }

        return -1;
    }

    private void update(int[] window, int[] frequency) {
        boolean[] isCounted = new boolean[frequency.length];
        for (int element: window) {
            if (!isCounted[element]) {
                isCounted[element] = true;
                frequency[element]++;
            }
        }
    }
}