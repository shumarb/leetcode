// Question: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/

class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        int requiredSize = (int) Math.pow(2.0, k);

        for (int i = 0; i <= s.length() - k; i++) {
            if (set.add(s.substring(i, i + k)) && set.size() == requiredSize) {
                return true;
            }
        }

        return false;
    }
}
