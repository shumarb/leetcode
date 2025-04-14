// Question: https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/

class FindMinimumOperationsToMakeAllElementsDivisibleByThree {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int number: nums) {
            if (number % 3 != 0) {
                count++;
            }
        }
        return count;
    }
}