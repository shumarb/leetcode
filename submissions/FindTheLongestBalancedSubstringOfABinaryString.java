// Question: https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/description/

class FindTheLongestBalancedSubstringOfABinaryString {
    public int findTheLongestBalancedSubstring(String s) {
        boolean isTest = false;
        int len = s.length();
        int longest = 0;

        for (int i = 0; i < len; i++) {
            if (isTest) {
                System.out.println("-----------------------------------");
            }
            StringBuilder current = new StringBuilder();
            current.append(s.charAt(i));
            for (int j = i + 1; j < len; j++) {
                current.append(s.charAt(j));
                if (isTest) {
                    System.out.println(" * check: " + current.toString());
                }
                if (isBalanced(current.toString())) {
                    longest = Math.max(current.length(), longest);
                    if (isTest) {
                        System.out.println(" ** valid: " + current.toString() + ", after compare, longest: " + longest);
                    }
                }
            }
        }

        return longest;
    }

    private boolean isBalanced(String current) {
        int countOne = 0;
        int countZero = 0;
        for (int i = 0; i < current.length(); i++) {
            char c = current.charAt(i);
            if (i + 1 < current.length() && c == '1' && current.charAt(i + 1) == '0') {
                return false;
            }
            if (c == '0') {
                countZero++;
            } else {
                countOne++;
            }
        }

        return countOne > 0 && countZero > 0 && countOne == countZero;
    }
}