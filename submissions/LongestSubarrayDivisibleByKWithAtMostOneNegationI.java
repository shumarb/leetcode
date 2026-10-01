// Question: https://leetcode.com/problems/longest-subarray-divisible-by-k-with-at-most-one-negation-i/description/

class LongestSubarrayDivisibleByKWithAtMostOneNegationI {
    public int longestSubarray(int[] nums, int k) {
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums) + "\n-----------------------------------------------------------------");
        }
        for (int i = 0; i < n; i++) {
            // 1. Checks if 2 * nums[i] % k encountered when negating nums[i].
            boolean[] isRemainderSeen = new boolean[k];
            long sum = 0;

            for (int j = i; j < n; j++) {
                int length = j - i + 1;
                sum += nums[j];

                int remainderAfterNegation = (int) (((2l * nums[j]) % k + k) % k); // 2. Add + k to deal with negative remainders.
                int sumRemainder = (int) (((sum % k) + k) % k);
                isRemainderSeen[remainderAfterNegation] = true;

                if (length > result && (sum % k == 0 || isRemainderSeen[sumRemainder])) {
                    if (isTest) {
                        System.out.println(" * indices: [" + i + ", " + j + "] | sum without negation: " + sum + " | possible negation @ index " + j + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)));
                    }
                    result = Math.max(length, result);

                    if (result == n) {
                        break;
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
