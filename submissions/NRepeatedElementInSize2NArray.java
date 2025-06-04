// Question: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/

class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] nums) {
        boolean[] isNumberPresent = new boolean[10001];
        for (int number: nums) {
            if (isNumberPresent[number]) {
                return number;
            }
            isNumberPresent[number] = true;
        }
        return -1;
    }
}