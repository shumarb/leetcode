// Question: https://leetcode.com/problems/count-subarrays-with-even-odd-ratio-i/description/

class CountSubarraysWithEvenOddRatioI {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        boolean isTest = false;
        double limit = (double) a / (double) b;
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int x = 0;
            int y = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    x++;

                } else {
                    y++;
                }

                if (y > 0 && x * b <= a * y) {
                    if (isTest) {
                        System.out.println(" * indices: [" + i + ", " + j + "] | x: " + x + ", y: " + y + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)));
                    }

                    result++;
                }
            }
        }

        return result;
    }
}
