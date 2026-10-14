// Question: https://leetcode.com/problems/longest-subarray-with-restricted-pair-sums/description/

class LongestSubarrayWithRestrictedPairSums {
    public int maxSubarray(int[] nums) {
        boolean isTest = false;
        int[] count = new int[1001];
        int left = 0;
        int n = nums.length;
        int result = 0;

        if (n <= 2) {
            return n;
        }

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\n-------------------------------------------------------------");
        }
        for (int right = 0; right < n; right++) {
            count[nums[right]]++;

            while (!isValid(count)) {
                --count[nums[left++]];
            }

            int length = right - left + 1;
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | length: " + length + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
            }

            result = Math.max(length, result);
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private boolean isValid(int[] count) {
        for (int a = 1; a <= 500; a++) {
            if (count[a] == 0) {
                continue;
            }

            for (int b = a; b <= 500; b++) {
                if (count[b] == 0) {
                    continue;
                }

                if (a == b && count[a] < 2) {
                    continue;
                }

                int sum = a + b;
                if (sum > 1000 || count[sum] == 0) {
                    continue;
                }

                int countNeeded = 1;
                if (sum == a) {
                    countNeeded++;
                }

                if (sum == b) {
                    countNeeded++;
                }

                if (count[sum] >= countNeeded) {
                    return false;
                }
            }
        }

        return true;
    }
}
