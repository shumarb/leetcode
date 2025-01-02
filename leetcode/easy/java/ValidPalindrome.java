class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                if (Character.isLetter(c)) {
                    c = Character.toLowerCase(c);
                }
                sb.append(c);
            }
        }
        char[] letters = sb.toString().toCharArray();
        int l = 0;
        int h = letters.length - 1;
        while (l < h) {
            if (letters[l++] != letters[h--]) {
                return false;
            }
        }
        return true;
    }

}
