// Question: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/

class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        // 1. No swaps if strings are the same.
        if (s1.equals(s2)) {
            return true;
        }

        int[] mismatchedIndices = new int[2];
        int countMismatchedIndices = 0;
        int j = 0;
        boolean isTest = false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                // 2. Impossible for 1 swap if number of mismatches characters is more than 2.
                countMismatchedIndices++;
                if (countMismatchedIndices > 2) {
                    return false;
                }
                mismatchedIndices[j++] = i;
            }
        }
        if (isTest) {
            System.out.println("s1: " + s1 + "\ns2: " + s2 + "\nmismatchedIndices: " + Arrays.toString(mismatchedIndices));
        }

        int firstIndex = mismatchedIndices[0];
        int secondIndex = mismatchedIndices[1];

        return s1.charAt(firstIndex) == s2.charAt(secondIndex) && s1.charAt(secondIndex) == s2.charAt(firstIndex);

    }
}