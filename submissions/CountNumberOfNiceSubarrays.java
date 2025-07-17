// Question: https://leetcode.com/problems/count-number-of-nice-subarrays/description/

class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int countOdd = 0;
        int countValidSubarrays = 0;
        int left = 0;
        int totalValidSubArrays = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) {
                countOdd++;
                countValidSubarrays = 0;
            }
            while (countOdd == k) {
                if (nums[left] % 2 == 1) {
                    countOdd--;
                }
                left++;
                countValidSubarrays++;
            }
            totalValidSubArrays += countValidSubarrays;
        }

        return totalValidSubArrays;
    }
}