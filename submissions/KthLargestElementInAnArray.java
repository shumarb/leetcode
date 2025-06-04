// Question: https://leetcode.com/problems/kth-largest-element-in-an-array/description/

class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int[] numberFrequency = new int[20001];

        for (int number: nums) {
            numberFrequency[number + 10000]++;
        }

        for (int i = numberFrequency.length - 1; i >= 0; i--) {
            while (numberFrequency[i] > 0) {
                k--;
                numberFrequency[i]--;
                if (k == 0) {
                    return i - 10000;
                }
            }
        }

        return 0;
    }
}