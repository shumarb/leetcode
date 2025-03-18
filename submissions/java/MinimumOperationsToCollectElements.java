// Question: https://leetcode.com/problems/minimum-operations-to-collect-elements/description/

class MinimumOperationsToCollectElements {
    public int minOperations(List<Integer> nums, int k) {
        int maximum = nums.get(0);
        for (int number: nums) {
            maximum = Math.max(maximum, number);
        }
        int[] elements = new int[maximum + 1];
        int minOperations = 0;
        int i = nums.size() - 1;

        while (!isValid(elements, k)) {
            elements[nums.get(i--)]++;
            minOperations++;
        }

        return minOperations;
    }

    private boolean isValid(int[] elements, int k) {
        for (int i = 1; i <= k; i++) {
            if (elements[i] == 0) {
                return false;
            }
        }
        return true;
    }
}