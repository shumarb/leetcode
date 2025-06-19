// Question: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/

class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        Set<String> checked = new HashSet<>();
        boolean isTest = false;

        for (int i = 0; i <= s.length() - k; i++) {
            StringBuilder window = new StringBuilder();
            for (int j = i; j < i + k; j++) {
                window.append(s.charAt(j));
            }
            if (!checked.contains(window.toString())) {
                if (isTest) {
                    System.out.println("window: " + window.toString());
                }
            }
            checked.add(window.toString());
        }

        return checked.size() == (int) Math.pow(2, k);
    }
}