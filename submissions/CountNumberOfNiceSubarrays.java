// Question: https://leetcode.com/problems/count-number-of-nice-subarrays/description/

class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int oddCount = 0;
        int total = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) {
                oddCount++;
                count = 0;
            }
            while (oddCount == k) {
                if (nums[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
                count++;
            }
            total += count;
        }

        return total;
    }
}