// Question: https://leetcode.com/problems/long-pressed-name/description/

class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                // 1. Current char is long-pressed.
                j++;
            } else {
                /**
                    2. Mismatch of current characters and current character of typed is not long-pressed.
                 */
                return false;
            }
        }

        /**
         3.  Exhausted all letters in word but not in typed,
             check if remaining characters in typed are valid long-pressed characters.
         */
        while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) {
            j++;
        }

        /**
         4.  Valid typed and name if both indices
             have traversed all characters in respective words.
         */
        return i == name.length() && j == typed.length();
    }
}