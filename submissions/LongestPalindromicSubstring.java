// Question:

class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        String longestPalindrome = Character.toString(s.charAt(0));
        boolean isTest = false;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String current = s.substring(i, j + 1);
                if (current.length() > longestPalindrome.length() && isPalindrome(current)) {
                    if (isTest) {
                        System.out.println(" * compare | current: " + current + ", longestPalindrome: "  + longestPalindrome);
                    }
                    longestPalindrome = current;
                }
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------");
            System.out.println("longestPalindrome: " + longestPalindrome);
        }

        return longestPalindrome;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}