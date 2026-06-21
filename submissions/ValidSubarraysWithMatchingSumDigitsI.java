// Question: https://leetcode.com/problems/valid-subarrays-with-matching-sum-digits-i/description/

class ValidSubarraysWithMatchingSumDigitsI {
    public int countValidSubarrays(int[] nums, int x) {
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (isValid(sum, x)) {
                    if (isTest) {
                        System.out.println(" * valid | indices: [" + i + ", " + i + "] | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)));
                    }
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isValid(long sum, int x) {
        String digits = Long.toString(sum);
        char check = (char) (x + '0');

        return digits.charAt(0) == check && digits.charAt(digits.length() - 1) == check;
    }
}
