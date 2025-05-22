// Question: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/

class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        // 1. No swaps if strings are the same.
        if (s1.equals(s2)) {
            return true;
        }

        List<Integer> mismatchedIndices = new ArrayList<>();
        boolean isTest = false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                mismatchedIndices.add(i);
            }
        }
        if (isTest) {
            System.out.println("s1: " + s1 + "\ns2: " + s2 + "\nmismatchedIndices: " + mismatchedIndices);
        }

        // 2. Impossible for swap if number of mismatched indices != 2
        if (mismatchedIndices.size() != 2) {
            return false;
        }

        int i = mismatchedIndices.get(0);
        int j = mismatchedIndices.get(1);

        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }
}