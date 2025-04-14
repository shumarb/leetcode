// Question: https://leetcode.com/problems/split-the-array/description/

class SplitTheArray {
    public boolean isPossibleToSplit(int[] nums) {
        int[] numberFrequency = new int[101];
        for (int number: nums) {
            /**
             1.  If number appears more than 2 times,
                 there will be at least 1 array with
                 duplicate values.
             */
            if (++numberFrequency[number] > 2) {
                return false;
            }
        }
        return true;
    }
}