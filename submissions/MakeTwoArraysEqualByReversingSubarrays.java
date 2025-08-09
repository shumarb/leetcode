// Question: https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/

class MakeTwoArraysEqualByReversingSubarrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        // 1. Edge case: Both are equal.
        if (Arrays.equals(target, arr)) {
            return true;
        }

        int[] arrFrequency = new int[1001];
        int[] targetFrequency = new int[1001];

        /**
            2. Both arrays can be made equal if both have same elements.
         */
        for (int number: arr) {
            arrFrequency[number]++;
        }
        for (int number: target) {
            targetFrequency[number]++;
        }

        return Arrays.equals(arrFrequency, targetFrequency);
    }
}