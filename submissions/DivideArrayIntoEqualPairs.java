// Question: https://leetcode.com/problems/divide-array-into-equal-pairs/description/

class DivideArrayIntoEqualPairs {
    public boolean divideArray(int[] nums) {
        int[] numberFrequency = new int[501];
        for (int number: nums) {
            numberFrequency[number]++;
        }
        for (int frequency: numberFrequency) {
            if (frequency % 2 == 1) {
                return false;
            }
        }

        return true;
    }
}