// Question: https://leetcode.com/problems/count-subarrays-with-even-odd-ratio-i/description/

class CountSubarraysWithEvenOddRatioI {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        boolean isTest = false;
        double limit = (double) a / (double) b;
        int n = nums.length;
        int result = 0;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\na: " + a + "\nb: " + b + "\nlimit: " + limit);
        }

        for (int i = 0; i < n; i++) {
            if (isTest) {
                System.out.println("-----------------------------------\ni: " + i);
            }
            int x = 0;
            int y = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    x++;
                } else {
                    y++;
                }

                double evenCount = x;
                double oddCount = y;
                double ratio = evenCount / oddCount;

                if (y > 0 && ratio <= limit) {
                    if (isTest) {
                        System.out.println(" * valid: | indices: [" + i + ", " + j + "] | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)) + " | evenCount: " + evenCount + ", oddCount: " + oddCount + " | ratio: " + ratio);
                    }

                    result++;
                }
            }
        }

        return result;
    }
}
