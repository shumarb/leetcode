// Question: https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/description/

class SumOfValuesAtIndicesWithKSetBits {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        boolean isTest = false;
        int len = nums.size();
        int sumIndicesWithKSetBits = 0;
        for (int i = 0; i < len; i++) {
            if (Integer.bitCount(i) == k) {
                sumIndicesWithKSetBits += nums.get(i);
            }
        }
        return sumIndicesWithKSetBits;
    }
}