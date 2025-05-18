// Question: https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/description/

class SumOfValuesAtIndicesWithKSetBits {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        boolean isTest = false;
        int len = nums.size();
        int sumIndicesWithKSetBits = 0;
        for (int i = 0; i < len; i++) {
            if (hasKSetBits(i, k)) {
                if (isTest) {
                    System.out.println(" ** adding: " + nums.get(i));
                }
                sumIndicesWithKSetBits += nums.get(i);
            }
        }
        return sumIndicesWithKSetBits;
    }

    private boolean hasKSetBits(int number, int k) {
        int countSetBits = 0;
        while (number != 0) {
            if (number % 2 == 1) {
                countSetBits++;
            }
            number /= 2;
        }
        return countSetBits == k;
    }
}