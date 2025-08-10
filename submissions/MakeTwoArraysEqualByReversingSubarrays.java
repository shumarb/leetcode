// Question: https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/

class MakeTwoArraysEqualByReversingSubarrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] frequency = new int[1001];
        int len = target.length;

        /**
            1. Both arrays can be made equal if both have same elements.
         */
        for (int i = 0; i < len; i++) {
            frequency[target[i]]++;
            frequency[arr[i]]--;
        }
        for (int count: frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}