// Question: https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/

class MakeTwoArraysEqualByReversingSubarrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        // 1. Edge case: Both are equal.
        if (Arrays.equals(target, arr)) {
            return true;
        }

        int[] frequency = new int[1001];

        /**
            2. Both arrays can be made equal if both have same elements.
         */
        for (int number: arr) {
            frequency[number]++;
        }
        for (int number: target) {
            frequency[number]--;
        }
        for (int i = 1; i <= 1000; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }

        return true;
    }
}