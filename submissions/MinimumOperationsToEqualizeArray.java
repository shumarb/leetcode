// Question: https://leetcode.com/problems/minimum-operations-to-equalize-array/description/

class MinimumOperationsToEqualizeArray {
    public int minOperations(int[] nums) {
        int[] frequency;
        int largest = nums[0];

        for (int number: nums) {
            largest = Math.max(largest, number);
        }
        frequency = new int[largest + 1];

        for (int number: nums) {
            frequency[number]++;
        }
        for (int i = 1; i <= largest; i++) {
            if (frequency[i] == 0) {
                continue;
            } else if (frequency[i] < nums.length) {
                return 1;
            }
        }

        return 0;
    }
}