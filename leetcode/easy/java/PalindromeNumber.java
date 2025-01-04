class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String xStr = String.valueOf(x);
        int l = 0;
        int r = xStr.length() - 1;
        while (l < r) {
            if (xStr.charAt(l++) != xStr.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

}