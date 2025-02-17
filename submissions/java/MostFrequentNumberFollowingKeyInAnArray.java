// Question: https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/description/

class MostFrequentNumberFollowingKeyInAnArray {
    public int mostFrequent(int[] nums, int key) {
        int[] frequency = new int[1001];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                frequency[nums[i + 1]]++;
            }
        }

        int result = 0;
        int maximumCount = 0;
        for (int i = 1; i <= 1000; i++) {
            if (frequency[i] > maximumCount) {
                maximumCount = frequency[i];
                result = i;
            }
        }

        return result;
    }
}