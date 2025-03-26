// Question: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/

class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int number: nums) {
            if (set.contains(number)) {
                return number;
            }
            set.add(number);
        }
        return -1;
    }
}