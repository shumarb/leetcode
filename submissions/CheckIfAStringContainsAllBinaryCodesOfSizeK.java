// Question: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/

class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        boolean isTest = false;

        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        if (isTest) {
            System.out.println("set: " + set);
        }

        return set.size() == (int) Math.pow(2, k);
    }
}